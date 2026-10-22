package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
class TypefaceCompatBaseImpl {
    private static final int INVALID_KEY = 0;
    private static final String TAG = "TypefaceCompatBaseImpl";
    private ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry> mFontFamilies;

    private interface StyleExtractor<T> {
        int getWeight(T r1);

        boolean isItalic(T r1);
    }

    TypefaceCompatBaseImpl() {
        this.mFontFamilies = new ConcurrentHashMap();
    }

    private void addFontFamily(Typeface r5, FontResourcesParserCompat.FontFamilyFilesResourceEntry r6) {
        long r0 = getUniqueKey(r5);
        if (r0 == 0) goto L6;
        this.mFontFamilies.put(Long.valueOf(r0), r6);
        return;
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry r2, int r3) {
        return (FontResourcesParserCompat.FontFileResourceEntry) ZeusTransformUtils.preCheckCast(findBestFont(r2.getEntries(), r3, new AnonymousClass2(this)), FontResourcesParserCompat.FontFileResourceEntry.class, "com.obric.memorydata.plugin");
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry r2, int r3, boolean r4) {
        return (FontResourcesParserCompat.FontFileResourceEntry) ZeusTransformUtils.preCheckCast(findBestFont(r2.getEntries(), r3, r4, new AnonymousClass3(this)), FontResourcesParserCompat.FontFileResourceEntry.class, "com.obric.memorydata.plugin");
    }

    private static <T> T findBestFont(T[] r2, int r3, StyleExtractor<T> r4) {
        StyleExtractor r5 = (StyleExtractor) ZeusTransformUtils.wrapperContextForParams(r4, StyleExtractor.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) != 0) goto L5;
        int r0 = 400;
    L7:
        if ((r3 & 2) == 0) goto L9;
        boolean r6 = true;
    L11:
        return (T) findBestFont(r2, r0, r6, r5);
    L9:
        r6 = false;
        goto L11
    L5:
        r0 = TypedValues.TransitionType.TYPE_DURATION;
        goto L7
    }

    private static <T> T findBestFont(T[] r8, int r9, boolean r10, StyleExtractor<T> r11) {
        StyleExtractor r12 = (StyleExtractor) ZeusTransformUtils.wrapperContextForParams(r11, StyleExtractor.class, "com.obric.memorydata.plugin");
        int r0 = r8.length;
        T r2 = null;
        int r3 = Integer.MAX_VALUE;
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L13;
        T r5 = r8[r4];
        int r6 = Math.abs(r12.getWeight(r5) - r9) * 2;
        if (r12.isItalic(r5) != r10) goto L7;
        int r7 = 0;
    L8:
        int r13 = r6 + r7;
        if (r2 == null) goto L11;
        if (r3 > r13) goto L11;
    L12:
        r4 = r4 + 1;
    L11:
        r2 = r5;
        r3 = r13;
        goto L12
    L7:
        r7 = 1;
        goto L8
    L13:
        return r2;
    }

    private static long getUniqueKey(Typeface r6) {
        if (r6 != null) goto L13;
        return 0;
    L13:
        Field r4 = Typeface.class.getDeclaredField("native_instance");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        r4.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        return ((Number) ZeusTransformUtils.preCheckCast(r4.get(r6), Number.class, "com.obric.memorydata.plugin")).longValue();
    L7:
        e = move-exception;
        Log.e(TAG, "Could not retrieve font from family.", e);
        return 0;
    L10:
        e = move-exception;
        Log.e(TAG, "Could not retrieve font from family.", e);
        return 0;
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context r7, FontResourcesParserCompat.FontFamilyFilesResourceEntry r8, Resources r9, int r10) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        FontResourcesParserCompat.FontFileResourceEntry r11 = findBestEntry(r8, r10);
        if (r11 != null) goto L6;
        return null;
    L6:
        Typeface r12 = TypefaceCompat.createFromResourcesFontFile(r0, r9, r11.getResourceId(), r11.getFileName(), 0, r10);
        addFontFamily(r12, r8);
        return r12;
    }

    Typeface createFromFontFamilyFilesResourceEntry(Context r7, FontResourcesParserCompat.FontFamilyFilesResourceEntry r8, Resources r9, int r10, boolean r11) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        FontResourcesParserCompat.FontFileResourceEntry r12 = findBestEntry(r8, r10, r11);
        if (r12 != null) goto L6;
        return null;
    L6:
        Typeface r13 = TypefaceCompat.createFromResourcesFontFile(r0, r9, r12.getResourceId(), r12.getFileName(), 0, 0);
        addFontFamily(r13, r8);
        return r13;
    }

    public Typeface createFromFontInfo(Context r3, CancellationSignal r4, FontsContractCompat.FontInfo[] r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        InputStream r0 = null;
        if (r5.length >= 1) goto L21;
        return null;
    L21:
        InputStream r8 = r7.getContentResolver().openInputStream(findBestInfo(r5, r6).getUri());     // Catch: Throwable -> L12 IOException -> L15
        Typeface r2 = createFromInputStream(r7, r8);     // Catch: Throwable -> L10 IOException -> L18
        TypefaceCompatUtil.closeQuietly(r8);
        return r2;
    L10:
        th = th;
        r0 = r8;
    L13:
        TypefaceCompatUtil.closeQuietly(r0);
        throw th;
    L16:
        TypefaceCompatUtil.closeQuietly(r8);
        return null;
    L15:
        r8 = null;
    L12:
        th = th;
        goto L13
    }

    public Typeface createFromInputStream(Context r2, InputStream r3) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.lang.Class<android.content.Context> r1 = android.content.Context.class
            java.lang.String r0 = "com.obric.memorydata.plugin"
            java.lang.Object r1 = com.volcengine.zeus.transform.ZeusTransformUtils.wrapperContextForParams(r2, r1, r0)
            android.content.Context r1 = (android.content.Context) r1
            java.io.File r1 = androidx.core.graphics.TypefaceCompatUtil.getTempFile(r1)
            r2 = 0
            if (r1 != 0) goto L12
            return r2
        L12:
            boolean r3 = androidx.core.graphics.TypefaceCompatUtil.copyToFile(r1, r3)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2d
            if (r3 != 0) goto L1c
            r1.delete()
            return r2
        L1c:
            java.lang.String r3 = r1.getPath()     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2d
            android.graphics.Typeface r2 = android.graphics.Typeface.createFromFile(r3)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2d
            r1.delete()
            return r2
        L28:
            r2 = move-exception
            r1.delete()
            throw r2
        L2d:
            r1.delete()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatBaseImpl.createFromInputStream(android.content.Context, java.io.InputStream):android.graphics.Typeface");
    }

    public Typeface createFromResourcesFontFile(Context r1, Resources r2, int r3, String r4, int r5) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.lang.Class<android.content.Context> r0 = android.content.Context.class
            java.lang.String r4 = "com.obric.memorydata.plugin"
            java.lang.Object r0 = com.volcengine.zeus.transform.ZeusTransformUtils.wrapperContextForParams(r1, r0, r4)
            android.content.Context r0 = (android.content.Context) r0
            java.io.File r0 = androidx.core.graphics.TypefaceCompatUtil.getTempFile(r0)
            r1 = 0
            if (r0 != 0) goto L12
            return r1
        L12:
            boolean r2 = androidx.core.graphics.TypefaceCompatUtil.copyToFile(r0, r2, r3)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2d
            if (r2 != 0) goto L1c
            r0.delete()
            return r1
        L1c:
            java.lang.String r2 = r0.getPath()     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2d
            android.graphics.Typeface r1 = android.graphics.Typeface.createFromFile(r2)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2d
            r0.delete()
            return r1
        L28:
            r1 = move-exception
            r0.delete()
            throw r1
        L2d:
            r0.delete()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatBaseImpl.createFromResourcesFontFile(android.content.Context, android.content.res.Resources, int, java.lang.String, int):android.graphics.Typeface");
    }

    Typeface createWeightStyle(Context r3, Typeface r4, int r5, boolean r6) {
        Typeface r2 = WeightTypefaceApi14.createWeightStyle(this, (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, r5, r6);     // Catch: RuntimeException -> L5
    L6:
        if (r2 != null) goto L9;
        return r4;
    L9:
        return r2;
    L5:
        r2 = null;
        goto L6
    }

    public FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] r2, int r3) {
        return (FontsContractCompat.FontInfo) ZeusTransformUtils.preCheckCast(findBestFont(r2, r3, new AnonymousClass1(this)), FontsContractCompat.FontInfo.class, "com.obric.memorydata.plugin");
    }

    FontResourcesParserCompat.FontFamilyFilesResourceEntry getFontFamily(Typeface r5) {
        long r0 = getUniqueKey(r5);
        if (r0 != 0) goto L7;
        return null;
    L7:
        return (FontResourcesParserCompat.FontFamilyFilesResourceEntry) ZeusTransformUtils.preCheckCast(this.mFontFamilies.get(Long.valueOf(r0)), FontResourcesParserCompat.FontFamilyFilesResourceEntry.class, "com.obric.memorydata.plugin");
    }
}

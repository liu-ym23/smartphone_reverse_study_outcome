package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TypefaceCompatBaseImpl {
    private static final int INVALID_KEY = 0;
    private static final String TAG = "TypefaceCompatBaseImpl";

    @SuppressLint({"BanConcurrentHashMap"})
    private ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry> mFontFamilies;

    private interface StyleExtractor<T> {
        int getWeight(T r10);

        boolean isItalic(T r10);
    }

    TypefaceCompatBaseImpl() {
        this.mFontFamilies = new ConcurrentHashMap();
    }

    private void addFontFamily(Typeface r10, FontResourcesParserCompat.FontFamilyFilesResourceEntry r11) {
        long r12 = getUniqueKey(r10);
        if (r12 == 0) goto L6;
        this.mFontFamilies.put(Long.valueOf(r12), r11);
        return;
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry r10, int r11) {
        return (FontResourcesParserCompat.FontFileResourceEntry) findBestFont(r10.getEntries(), r11, new AnonymousClass2(this));
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry r10, int r11, boolean r12) {
        return (FontResourcesParserCompat.FontFileResourceEntry) findBestFont(r10.getEntries(), r11, r12, new AnonymousClass3(this));
    }

    private static <T> T findBestFont(T[] r10, int r11, StyleExtractor<T> r12) {
        if ((r11 & 1) != 0) goto L5;
        int r13 = 400;
    L7:
        if ((r11 & 2) == 0) goto L9;
        boolean r14 = true;
    L11:
        return (T) findBestFont(r10, r13, r14, r12);
    L9:
        r14 = false;
        goto L11
    L5:
        r13 = TypedValues.TransitionType.TYPE_DURATION;
        goto L7
    }

    private static <T> T findBestFont(T[] r10, int r11, boolean r12, StyleExtractor<T> r13) {
        int r14 = r10.length;
        T r15 = null;
        int r16 = Integer.MAX_VALUE;
        int r17 = 0;
    L3:
        if (r17 >= r14) goto L13;
        T r18 = r10[r17];
        int r19 = Math.abs(r13.getWeight(r18) - r11) * 2;
        if (r13.isItalic(r18) != r12) goto L7;
        int r20 = 0;
    L8:
        int r21 = r19 + r20;
        if (r15 == null) goto L11;
        if (r16 > r21) goto L11;
    L12:
        r17 = r17 + 1;
    L11:
        r15 = r18;
        r16 = r21;
        goto L12
    L7:
        r20 = 1;
        goto L8
    L13:
        return r15;
    }

    private static long getUniqueKey(@Nullable Typeface r10) {
        if (r10 != null) goto L13;
        return 0;
    L13:
        Field r11 = Typeface.class.getDeclaredField("native_instance");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        r11.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        return ((Number) r11.get(r10)).longValue();
    L7:
        e = move-exception;
        Log.e(TAG, "Could not retrieve font from family.", e);
        return 0;
    L10:
        e = move-exception;
        Log.e(TAG, "Could not retrieve font from family.", e);
        return 0;
    }

    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context r10, FontResourcesParserCompat.FontFamilyFilesResourceEntry r11, Resources r12, int r13) {
        FontResourcesParserCompat.FontFileResourceEntry r14 = findBestEntry(r11, r13);
        if (r14 != null) goto L6;
        return null;
    L6:
        Typeface r15 = TypefaceCompat.createFromResourcesFontFile(r10, r12, r14.getResourceId(), r14.getFileName(), 0, r13);
        addFontFamily(r15, r11);
        return r15;
    }

    @Nullable
    Typeface createFromFontFamilyFilesResourceEntry(Context r10, FontResourcesParserCompat.FontFamilyFilesResourceEntry r11, Resources r12, int r13, boolean r14) {
        FontResourcesParserCompat.FontFileResourceEntry r15 = findBestEntry(r11, r13, r14);
        if (r15 != null) goto L6;
        return null;
    L6:
        Typeface r16 = TypefaceCompat.createFromResourcesFontFile(r10, r12, r15.getResourceId(), r15.getFileName(), 0, 0);
        addFontFamily(r16, r11);
        return r16;
    }

    @Nullable
    public Typeface createFromFontInfo(Context r10, @Nullable CancellationSignal r11, @NonNull FontsContractCompat.FontInfo[] r12, int r13) {
        InputStream r14 = null;
        if (r12.length >= 1) goto L19;
        return null;
    L19:
        InputStream r15 = r10.getContentResolver().openInputStream(findBestInfo(r12, r13).getUri());     // Catch: Throwable -> L12 IOException -> L15
    L21:
        Typeface r16 = createFromInputStream(r10, r15);     // Catch: Throwable -> L10 IOException -> L18
        TypefaceCompatUtil.closeQuietly(r15);
        return r16;
    L10:
        th = th;
        r14 = r15;
    L13:
        TypefaceCompatUtil.closeQuietly(r14);
        throw th;
    L16:
        TypefaceCompatUtil.closeQuietly(r15);
        return null;
    L15:
        r15 = null;
    L12:
        th = th;
        goto L13
    }

    protected Typeface createFromInputStream(Context r10, InputStream r11) {
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
            java.io.File r0 = androidx.core.graphics.TypefaceCompatUtil.getTempFile(r1)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            boolean r2 = androidx.core.graphics.TypefaceCompatUtil.copyToFile(r0, r2)     // Catch: java.lang.Throwable -> L1e java.lang.RuntimeException -> L23
            if (r2 != 0) goto L12
            r0.delete()
            return r1
        L12:
            java.lang.String r2 = r0.getPath()     // Catch: java.lang.Throwable -> L1e java.lang.RuntimeException -> L23
            android.graphics.Typeface r1 = android.graphics.Typeface.createFromFile(r2)     // Catch: java.lang.Throwable -> L1e java.lang.RuntimeException -> L23
            r0.delete()
            return r1
        L1e:
            r1 = move-exception
            r0.delete()
            throw r1
        L23:
            r0.delete()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatBaseImpl.createFromInputStream(android.content.Context, java.io.InputStream):android.graphics.Typeface");
    }

    @Nullable
    public Typeface createFromResourcesFontFile(Context r10, Resources r11, int r12, String r13, int r14) {
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
            java.io.File r0 = androidx.core.graphics.TypefaceCompatUtil.getTempFile(r1)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            boolean r2 = androidx.core.graphics.TypefaceCompatUtil.copyToFile(r0, r2, r3)     // Catch: java.lang.Throwable -> L1e java.lang.RuntimeException -> L23
            if (r2 != 0) goto L12
            r0.delete()
            return r1
        L12:
            java.lang.String r2 = r0.getPath()     // Catch: java.lang.Throwable -> L1e java.lang.RuntimeException -> L23
            android.graphics.Typeface r1 = android.graphics.Typeface.createFromFile(r2)     // Catch: java.lang.Throwable -> L1e java.lang.RuntimeException -> L23
            r0.delete()
            return r1
        L1e:
            r1 = move-exception
            r0.delete()
            throw r1
        L23:
            r0.delete()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatBaseImpl.createFromResourcesFontFile(android.content.Context, android.content.res.Resources, int, java.lang.String, int):android.graphics.Typeface");
    }

    @NonNull
    Typeface createWeightStyle(@NonNull Context r10, @NonNull Typeface r11, int r12, boolean r13) {
        Typeface r14 = WeightTypefaceApi14.createWeightStyle(this, r10, r11, r12, r13);     // Catch: RuntimeException -> L4
    L5:
        if (r14 != null) goto L8;
        return r11;
    L8:
        return r14;
    L4:
        r14 = null;
        goto L5
    }

    protected FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] r10, int r11) {
        return (FontsContractCompat.FontInfo) findBestFont(r10, r11, new AnonymousClass1(this));
    }

    @Nullable
    FontResourcesParserCompat.FontFamilyFilesResourceEntry getFontFamily(Typeface r10) {
        long r11 = getUniqueKey(r10);
        if (r11 != 0) goto L7;
        return null;
    L7:
        return this.mFontFamilies.get(Long.valueOf(r11));
    }
}

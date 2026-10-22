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

    public interface StyleExtractor<T> {
        int getWeight(T r5);

        boolean isItalic(T r5);
    }

    public TypefaceCompatBaseImpl() {
        this.mFontFamilies = new ConcurrentHashMap();
    }

    private void addFontFamily(Typeface r5, FontResourcesParserCompat.FontFamilyFilesResourceEntry r10) {
        long r11 = getUniqueKey(r5);
        if (r11 == 0) goto L6;
        this.mFontFamilies.put(Long.valueOf(r11), r10);
        return;
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry r5, int r10) {
        return (FontResourcesParserCompat.FontFileResourceEntry) findBestFont(r5.getEntries(), r10, new AnonymousClass2(this));
    }

    private static <T> T findBestFont(T[] r5, int r10, StyleExtractor<T> r11) {
        if ((r10 & 1) != 0) goto L5;
        int r12 = 400;
    L7:
        if ((r10 & 2) == 0) goto L9;
        boolean r13 = true;
    L11:
        return (T) findBestFont(r5, r12, r13, r11);
    L9:
        r13 = false;
        goto L11
    L5:
        r12 = 700;
        goto L7
    }

    private static long getUniqueKey(@Nullable Typeface r10) {
        if (r10 != null) goto L15;
        return 0;
    L15:
        Field r5 = Typeface.class.getDeclaredField("native_instance");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        r5.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        return ((Number) r5.get(r10)).longValue();
    L7:
        e = move-exception;
        Log.e(TAG, "Could not retrieve font from family.", e);
        return 0;
    L9:
        e = move-exception;
        Log.e(TAG, "Could not retrieve font from family.", e);
        return 0;
    }

    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context r10, FontResourcesParserCompat.FontFamilyFilesResourceEntry r11, Resources r12, int r13) {
        FontResourcesParserCompat.FontFileResourceEntry r5 = findBestEntry(r11, r13);
        if (r5 != null) goto L6;
        return null;
    L6:
        Typeface r14 = TypefaceCompat.createFromResourcesFontFile(r10, r12, r5.getResourceId(), r5.getFileName(), 0, r13);
        addFontFamily(r14, r11);
        return r14;
    }

    @Nullable
    public Typeface createFromFontInfo(Context r5, @Nullable CancellationSignal r10, @NonNull FontsContractCompat.FontInfo[] r11, int r12) {
        InputStream r13 = null;
        if (r11.length >= 1) goto L22;
        return null;
    L22:
        InputStream r14 = r5.getContentResolver().openInputStream(findBestInfo(r11, r12).getUri());     // Catch: Throwable -> L12 IOException -> L14
        Typeface r15 = createFromInputStream(r5, r14);     // Catch: Throwable -> L10 IOException -> L19
        TypefaceCompatUtil.closeQuietly(r14);
        return r15;
    L10:
        th = th;
        r13 = r14;
    L15:
        TypefaceCompatUtil.closeQuietly(r13);
        throw th;
    L17:
        TypefaceCompatUtil.closeQuietly(r14);
        return null;
    L14:
        r14 = null;
    L12:
        th = th;
        goto L15
    }

    public Typeface createFromInputStream(Context r5, InputStream r10) {
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
    public Typeface createFromResourcesFontFile(Context r5, Resources r10, int r11, String r12, int r13) {
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
    public Typeface createWeightStyle(@NonNull Context r5, @NonNull Typeface r10, int r11, boolean r12) {
        Typeface r13 = WeightTypefaceApi14.createWeightStyle(this, r5, r10, r11, r12);     // Catch: RuntimeException -> L4
    L5:
        if (r13 != null) goto L8;
        return r10;
    L8:
        return r13;
    L4:
        r13 = null;
        goto L5
    }

    public FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] r5, int r10) {
        return (FontsContractCompat.FontInfo) findBestFont(r5, r10, new AnonymousClass1(this));
    }

    @Nullable
    public FontResourcesParserCompat.FontFamilyFilesResourceEntry getFontFamily(Typeface r5) {
        long r10 = getUniqueKey(r5);
        if (r10 != 0) goto L7;
        return null;
    L7:
        return this.mFontFamilies.get(Long.valueOf(r10));
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry r5, int r10, boolean r11) {
        return (FontResourcesParserCompat.FontFileResourceEntry) findBestFont(r5.getEntries(), r10, r11, new AnonymousClass3(this));
    }

    private static <T> T findBestFont(T[] r10, int r11, boolean r12, StyleExtractor<T> r13) {
        int r5 = r10.length;
        T r14 = null;
        int r15 = Integer.MAX_VALUE;
        int r16 = 0;
    L3:
        if (r16 >= r5) goto L13;
        T r17 = r10[r16];
        int r18 = Math.abs(r13.getWeight(r17) - r11) * 2;
        if (r13.isItalic(r17) != r12) goto L7;
        int r19 = 0;
    L8:
        int r20 = r18 + r19;
        if (r14 == null) goto L11;
        if (r15 > r20) goto L11;
    L12:
        r16 = r16 + 1;
    L11:
        r14 = r17;
        r15 = r20;
        goto L12
    L7:
        r19 = 1;
        goto L8
    L13:
        return r14;
    }

    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context r10, FontResourcesParserCompat.FontFamilyFilesResourceEntry r11, Resources r12, int r13, boolean r14) {
        FontResourcesParserCompat.FontFileResourceEntry r15 = findBestEntry(r11, r13, r14);
        if (r15 != null) goto L6;
        return null;
    L6:
        Typeface r16 = TypefaceCompat.createFromResourcesFontFile(r10, r12, r15.getResourceId(), r15.getFileName(), 0, 0);
        addFontFamily(r16, r11);
        return r16;
    }
}

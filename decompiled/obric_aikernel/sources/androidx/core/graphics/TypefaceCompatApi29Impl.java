package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TypefaceCompatApi29Impl extends TypefaceCompatBaseImpl {
    public TypefaceCompatApi29Impl() {
    }

    private Font findBaseFont(@NonNull FontFamily r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        int r12 = TypedValues.TransitionType.TYPE_DURATION;
    L6:
        int r13 = 1;
        if ((r11 & 2) == 0) goto L9;
        int r14 = 1;
    L10:
        FontStyle r15 = new FontStyle(r12, r14);
        Font r16 = r10.getFont(0);
        int r17 = getMatchScore(r15, r16.getStyle());
    L12:
        if (r13 >= r10.getSize()) goto L17;
        Font r18 = r10.getFont(r13);
        int r19 = getMatchScore(r15, r18.getStyle());
        if (r19 >= r17) goto L16;
        r16 = r18;
        r17 = r19;
    L16:
        r13 = r13 + 1;
        goto L12
    L17:
        return r16;
    L9:
        r14 = 0;
        goto L10
    L5:
        r12 = 400;
        goto L6
    }

    private static int getMatchScore(@NonNull FontStyle r10, @NonNull FontStyle r11) {
        int r12 = Math.abs(r10.getWeight() - r11.getWeight()) / 100;
        if (r10.getSlant() != r11.getSlant()) goto L5;
        int r13 = 0;
    L7:
        return r12 + r13;
    L5:
        r13 = 2;
        goto L7
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context r10, FontResourcesParserCompat.FontFamilyFilesResourceEntry r11, Resources r12, int r13) {
        FontResourcesParserCompat.FontFileResourceEntry[] r14 = r11.getEntries();     // Catch: Exception -> L19
        int r15 = r14.length;     // Catch: Exception -> L19
        FontFamily.Builder r16 = null;
        int r17 = 0;
    L4:
        if (r17 >= r15) goto L15;
        FontResourcesParserCompat.FontFileResourceEntry r18 = r14[r17];     // Catch: Exception -> L19
        Font.Builder r19 = new Font.Builder(r12, r18.getResourceId()).setWeight(r18.getWeight());     // Catch: IOException -> L20 Exception -> L19
        if (r18.isItalic() == false) goto L9;
        int r20 = 1;
    L10:
        Font r21 = r19.setSlant(r20).setTtcIndex(r18.getTtcIndex()).setFontVariationSettings(r18.getVariationSettings()).build();     // Catch: IOException -> L20 Exception -> L19
        if (r16 != null) goto L13;
        r16 = new FontFamily.Builder(r21);     // Catch: IOException -> L20 Exception -> L19
        goto L14
    L13:
        r16.addFont(r21);     // Catch: IOException -> L20 Exception -> L19
        goto L14
    L9:
        r20 = 0;
    L14:
        r17 = r17 + 1;
        goto L4
    L15:
        if (r16 != null) goto L17;
        return null;
    L17:
        FontFamily r22 = r16.build();     // Catch: Exception -> L19
        return new Typeface.CustomFallbackBuilder(r22).setStyle(findBaseFont(r22, r13).getStyle()).build();
    L19:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontInfo(Context r10, @Nullable CancellationSignal r11, @NonNull FontsContractCompat.FontInfo[] r12, int r13) {
        ContentResolver r14 = r10.getContentResolver();
        int r15 = r12.length;     // Catch: Exception -> L31
        FontFamily.Builder r16 = null;
        int r17 = 0;
    L4:
        if (r17 >= r15) goto L27;
        FontsContractCompat.FontInfo r18 = r12[r17];     // Catch: Exception -> L31
        ParcelFileDescriptor r19 = r14.openFileDescriptor(r18.getUri(), "r", r11);     // Catch: IOException -> L32 Exception -> L31
        if (r19 != null) goto L33;
        if (r19 == null) goto L26;
    L9:
        r19.close();     // Catch: IOException -> L32 Exception -> L31
        goto L26
    L33:
        Font.Builder r20 = new Font.Builder(r19).setWeight(r18.getWeight());     // Catch: Throwable -> L20
        if (r18.isItalic() == false) goto L14;
        int r21 = 1;
    L15:
        Font r22 = r20.setSlant(r21).setTtcIndex(r18.getTtcIndex()).build();     // Catch: Throwable -> L20
        if (r16 != null) goto L18;
        r16 = new FontFamily.Builder(r22);     // Catch: Throwable -> L20
        goto L9
    L18:
        r16.addFont(r22);     // Catch: Throwable -> L20
        goto L9
    L14:
        r21 = 0;
    L20:
        th = move-exception;
        r19.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: IOException -> L32 Exception -> L31
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L32 Exception -> L31
    L26:
        r17 = r17 + 1;
        goto L4
    L27:
        if (r16 != null) goto L29;
        return null;
    L29:
        FontFamily r110 = r16.build();     // Catch: Exception -> L31
        return new Typeface.CustomFallbackBuilder(r110).setStyle(findBaseFont(r110, r13).getStyle()).build();
    L31:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    protected Typeface createFromInputStream(Context r10, InputStream r11) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromResourcesFontFile(Context r10, Resources r11, int r12, String r13, int r14) {
        Font r15 = new Font.Builder(r11, r12).build();     // Catch: Exception -> L4
        return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(r15).build()).setStyle(r15.getStyle()).build();
    L4:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @NonNull
    Typeface createWeightStyle(@NonNull Context r10, @NonNull Typeface r11, int r12, boolean r13) {
        return Typeface.create(r11, r12, r13);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    protected FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] r10, int r11) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}

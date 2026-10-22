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

    private Font findBaseFont(@NonNull FontFamily r5, int r10) {
        if ((r10 & 1) == 0) goto L5;
        int r11 = 700;
    L6:
        int r12 = 1;
        if ((r10 & 2) == 0) goto L9;
        int r13 = 1;
    L10:
        FontStyle r14 = new FontStyle(r11, r13);
        Font r15 = r5.getFont(0);
        int r16 = getMatchScore(r14, r15.getStyle());
    L12:
        if (r12 >= r5.getSize()) goto L17;
        Font r17 = r5.getFont(r12);
        int r18 = getMatchScore(r14, r17.getStyle());
        if (r18 >= r16) goto L16;
        r15 = r17;
        r16 = r18;
    L16:
        r12 = r12 + 1;
        goto L12
    L17:
        return r15;
    L9:
        r13 = 0;
        goto L10
    L5:
        r11 = 400;
        goto L6
    }

    private static int getMatchScore(@NonNull FontStyle r5, @NonNull FontStyle r10) {
        int r11 = Math.abs(r5.getWeight() - r10.getWeight()) / 100;
        if (r5.getSlant() != r10.getSlant()) goto L5;
        int r12 = 0;
    L7:
        return r11 + r12;
    L5:
        r12 = 2;
        goto L7
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context r10, FontResourcesParserCompat.FontFamilyFilesResourceEntry r11, Resources r12, int r13) {
        FontResourcesParserCompat.FontFileResourceEntry[] r14 = r11.getEntries();     // Catch: Exception -> L15
        int r5 = r14.length;     // Catch: Exception -> L15
        int r15 = 0;
        FontFamily.Builder r16 = null;
    L4:
        if (r15 >= r5) goto L11;
        FontResourcesParserCompat.FontFileResourceEntry r17 = r14[r15];     // Catch: Exception -> L15
        Font r18 = new Font.Builder(r12, r17.getResourceId()).setWeight(r17.getWeight()).setSlant(r17.isItalic() ? 1 : 0).setTtcIndex(r17.getTtcIndex()).setFontVariationSettings(r17.getVariationSettings()).build();     // Catch: IOException -> L16 Exception -> L15
        if (r16 != null) goto L9;
        r16 = new FontFamily.Builder(r18);     // Catch: IOException -> L16 Exception -> L15
        goto L10
    L9:
        r16.addFont(r18);     // Catch: IOException -> L16 Exception -> L15
    L10:
        r15 = r15 + 1;
        goto L4
    L11:
        if (r16 != null) goto L13;
        return null;
    L13:
        FontFamily r19 = r16.build();     // Catch: Exception -> L15
        return new Typeface.CustomFallbackBuilder(r19).setStyle(findBaseFont(r19, r13).getStyle()).build();
    L15:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontInfo(Context r10, @Nullable CancellationSignal r11, @NonNull FontsContractCompat.FontInfo[] r12, int r13) {
        ContentResolver r14 = r10.getContentResolver();
        int r5 = r12.length;     // Catch: Exception -> L28
        int r15 = 0;
        FontFamily.Builder r16 = null;
    L4:
        if (r15 >= r5) goto L24;
        FontsContractCompat.FontInfo r17 = r12[r15];     // Catch: Exception -> L28
        ParcelFileDescriptor r18 = r14.openFileDescriptor(r17.getUri(), "r", r11);     // Catch: IOException -> L29 Exception -> L28
        if (r18 != null) goto L34;
        if (r18 == null) goto L23;
    L9:
        r18.close();     // Catch: IOException -> L29 Exception -> L28
        goto L23
    L34:
        Font r19 = new Font.Builder(r18).setWeight(r17.getWeight()).setSlant(r17.isItalic() ? 1 : 0).setTtcIndex(r17.getTtcIndex()).build();     // Catch: Throwable -> L14
        if (r16 != null) goto L16;
        r16 = new FontFamily.Builder(r19);     // Catch: Throwable -> L14
        goto L9
    L16:
        r16.addFont(r19);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r18.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: IOException -> L29 Exception -> L28
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L29 Exception -> L28
    L23:
        r15 = r15 + 1;
        goto L4
    L24:
        if (r16 != null) goto L26;
        return null;
    L26:
        FontFamily r20 = r16.build();     // Catch: Exception -> L28
        return new Typeface.CustomFallbackBuilder(r20).setStyle(findBaseFont(r20, r13).getStyle()).build();
    L28:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromInputStream(Context r5, InputStream r10) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromResourcesFontFile(Context r5, Resources r10, int r11, String r12, int r13) {
        Font r14 = new Font.Builder(r10, r11).build();     // Catch: Exception -> L4
        return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(r14).build()).setStyle(r14.getStyle()).build();
    L4:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @NonNull
    public Typeface createWeightStyle(@NonNull Context r5, @NonNull Typeface r10, int r11, boolean r12) {
        return Typeface.create(r10, r11, r12);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] r5, int r10) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}

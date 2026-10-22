package com.bytedance.byted_bach_sdk.input;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class BachBitmapInput implements BachAlgorithmInput {
    protected Bitmap m_bitmap;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1956b;

        public a() {
            this.f1955a = 720;
            this.f1956b = 1280;
        }
    }

    public BachBitmapInput(Bitmap r1) {
        this.m_bitmap = r1;
    }

    public BachBitmapInput(String r2) {
        this(r2, new a());
    }

    public BachBitmapInput(String r1, a r2) {
        this.m_bitmap = decodeImage(r1, r2);
    }

    private static int calculateInSampleSize(BitmapFactory.Options r3, int r4, int r5) {
        int r0 = r3.outHeight;
        int r6 = r3.outWidth;
        int r1 = 1;
        if (r0 > r5) goto L5;
        if (r6 > r4) goto L5;
    L11:
        return r1;
    L5:
        int r2 = r0 / 2;
        int r7 = r6 / 2;
    L7:
        if ((r2 / r1) < r5) goto L11;
        if ((r7 / r1) < r4) goto L11;
        r1 = r1 * 2;
        goto L7
    }

    private Bitmap decodeImage(String r4, a r5) {
        File r3 = new File(r4);
        if (r3.exists() == true) goto L5;
    L15:
        System.err.println(String.format("invalid image path %s", new Object[]{r4}));
        return null;
    L5:
        if (r3.isFile() == false) goto L15;
        int r6 = r5.f1955a;
        int r7 = r5.f1956b;
        if (r6 <= 0) goto L14;
        if (r7 <= 0) goto L14;
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        r0.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r4);
        int r8 = calculateInSampleSize(r0, r6, r7);
        r0.inJustDecodeBounds = false;
        r0.inSampleSize = r8;
        return BitmapFactory.decodeFile(r4);
    L14:
        return BitmapFactory.decodeFile(r4);
    }

    @Override // com.bytedance.byted_bach_sdk.input.BachAlgorithmInput
    public Bitmap getInput() {
        return this.m_bitmap;
    }

    @Override // com.bytedance.byted_bach_sdk.input.BachAlgorithmInput
    public /* bridge */ /* synthetic */ Object getInput() {
        return getInput();
    }

    @Override // com.bytedance.byted_bach_sdk.input.BachAlgorithmInput
    public int getInputType() {
        return 1;
    }
}

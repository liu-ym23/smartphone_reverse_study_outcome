package com.lynx.tasm.service;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface ILynxTextService extends IServiceProvider {

    /* JADX INFO: renamed from: com.lynx.tasm.service.ILynxTextService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Class $default$getServiceClass(ILynxTextService r0) {
            return ILynxTextService.class;
        }
    }

    public static class LynxTextInfo {
        private final String[] content;
        private final double height;
        private final double width;

        public String[] getContent() {
            String[] r0 = this.content;
            if (r0 != null) goto L6;
            return null;
        L6:
            return (String[]) r0.clone();
        }

        public double getHeight() {
            return this.height;
        }

        public double getWidth() {
            return this.width;
        }

        public LynxTextInfo(double r7) {
            this(r7, 0.0d, null);
        }

        public LynxTextInfo(double r7, String[] r9) {
            this(r7, 0.0d, r9);
        }

        public LynxTextInfo(double r7, double r9) {
            this(r7, r9, null);
        }

        public LynxTextInfo(double r1, double r3, String[] r5) {
            this.width = r1;
            this.height = r3;
            if (r5 != null) goto L5;
            String[] r2 = null;
        L6:
            this.content = r2;
            return;
        L5:
            r2 = (String[]) r5.clone();
            goto L6
        }
    }

    public interface a {
        int a();

        String b(int r1, int r2);

        float[] c(int r1, int r2);

        void d(Canvas r1, Drawable.Callback r2);

        void destroy();

        int[] e(float r1, float r2);

        int f(float r1, float r2);
    }

    a createPage(long r1);

    long createTextLayoutAPI(Object r1);

    void destroyTextLayoutAPI(long r1);

    @Override // com.lynx.tasm.service.IServiceProvider
    Class<? extends IServiceProvider> getServiceClass();

    LynxTextInfo getTextInfo(String r1, String r2, String r3, String r4, int r5);
}

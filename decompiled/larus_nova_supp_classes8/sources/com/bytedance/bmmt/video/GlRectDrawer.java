package com.bytedance.bmmt.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class GlRectDrawer extends GlGenericDrawer {
    private static final String FRAGMENT_SHADER = "void main() {\n  gl_FragColor = sample(tc);\n}\n";

    public static class ShaderCallbacks implements GlGenericDrawer.ShaderCallbacks {
        private ShaderCallbacks() {
        }

        public /* synthetic */ ShaderCallbacks(int r1) {
            this();
        }

        @Override // com.bytedance.bmmt.video.GlGenericDrawer.ShaderCallbacks
        public void onNewShader(GlShader r1) {
        }

        @Override // com.bytedance.bmmt.video.GlGenericDrawer.ShaderCallbacks
        public void onPrepareShader(GlShader r1, float[] r2, int r3, int r4, int r5, int r6) {
        }
    }

    public GlRectDrawer() {
        super(FRAGMENT_SHADER, new ShaderCallbacks(0));
    }
}

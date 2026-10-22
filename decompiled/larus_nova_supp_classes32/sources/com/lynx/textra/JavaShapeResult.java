package com.lynx.textra;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
class JavaShapeResult {
    public float[] advance_;
    public int glyph_count_;
    public short[] glyphs_;
    public float[] position_x_;
    public float[] position_y_;
    public long[] typeface_instance_;

    public JavaShapeResult(int r2) {
        this.glyphs_ = new short[r2];
        this.advance_ = new float[r2];
        this.position_x_ = new float[r2];
        this.position_y_ = new float[r2];
        this.typeface_instance_ = new long[r2];
        this.glyph_count_ = r2;
    }
}

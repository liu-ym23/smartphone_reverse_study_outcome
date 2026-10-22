package com.bytedance.android.live.platformplayer.layout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g1 implements com.bytedance.android.live.matchroom.d {
    public final /* synthetic */ c a;

    @Override // com.bytedance.android.live.matchroom.d
    public final void reset() {
        this.a.setTranslationX(0.0f);
        this.a.setTranslationY(0.0f);
        this.a.setScaleX(1.0f);
        this.a.setScaleY(1.0f);
        this.a.requestLayout("MatchRoomLandScapeAnimUtil reset");
    }

    public g1(c r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.matchroom.d
    public final void a(float r2) {
        this.a.setTranslationX(r2);
        this.a.requestLayout("MatchRoomLandScapeAnimUtil X");
    }

    @Override // com.bytedance.android.live.matchroom.d
    public final void b(float r2) {
        this.a.setTranslationY(r2);
        this.a.requestLayout("MatchRoomLandScapeAnimUtil Y");
    }

    @Override // com.bytedance.android.live.matchroom.d
    public final void c(float r2, float r3) {
        this.a.setScaleX(r2);
        this.a.setScaleY(r3);
        this.a.requestLayout("MatchRoomLandScapeAnimUtil Scale");
    }
}

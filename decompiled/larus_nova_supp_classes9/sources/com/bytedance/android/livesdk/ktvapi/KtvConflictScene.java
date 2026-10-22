package com.bytedance.android.livesdk.ktvapi;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/KtvConflictScene;", BuildConfig.FLAVOR, "SCENE_NONE", "SCENE_ANCHOR_GAME", "SCENE_DRAW_AND_GUESS", "SCENE_SOUND_EFFECT", "SCENE_KTV", "SCENE_KSONG", "SCENE_KTV_CHORUS", "SCENE_INTERACTIVE_SONG", "SCENE_PAUSE_LIVE", "SCENE_WGAME", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum KtvConflictScene extends Enum<KtvConflictScene> {
    public static final KtvConflictScene SCENE_ANCHOR_GAME = null;
    public static final KtvConflictScene SCENE_DRAW_AND_GUESS = null;
    public static final KtvConflictScene SCENE_INTERACTIVE_SONG = null;
    public static final KtvConflictScene SCENE_KSONG = null;
    public static final KtvConflictScene SCENE_KTV = null;
    public static final KtvConflictScene SCENE_KTV_CHORUS = null;
    public static final KtvConflictScene SCENE_NONE = null;
    public static final KtvConflictScene SCENE_PAUSE_LIVE = null;
    public static final KtvConflictScene SCENE_SOUND_EFFECT = null;
    public static final KtvConflictScene SCENE_WGAME = null;
    public static final /* synthetic */ KtvConflictScene[] a = null;

    static {
        KtvConflictScene r1 = new KtvConflictScene("SCENE_NONE", 0);
        SCENE_NONE = r1;
        KtvConflictScene r2 = new KtvConflictScene("SCENE_ANCHOR_GAME", 1);
        SCENE_ANCHOR_GAME = r2;
        KtvConflictScene r3 = new KtvConflictScene("SCENE_DRAW_AND_GUESS", 2);
        SCENE_DRAW_AND_GUESS = r3;
        KtvConflictScene r4 = new KtvConflictScene("SCENE_SOUND_EFFECT", 3);
        SCENE_SOUND_EFFECT = r4;
        KtvConflictScene r5 = new KtvConflictScene("SCENE_KTV", 4);
        SCENE_KTV = r5;
        KtvConflictScene r6 = new KtvConflictScene("SCENE_KSONG", 5);
        SCENE_KSONG = r6;
        KtvConflictScene r7 = new KtvConflictScene("SCENE_KTV_CHORUS", 6);
        SCENE_KTV_CHORUS = r7;
        KtvConflictScene r8 = new KtvConflictScene("SCENE_INTERACTIVE_SONG", 7);
        SCENE_INTERACTIVE_SONG = r8;
        KtvConflictScene r9 = new KtvConflictScene("SCENE_PAUSE_LIVE", 8);
        SCENE_PAUSE_LIVE = r9;
        KtvConflictScene r10 = new KtvConflictScene("SCENE_WGAME", 9);
        SCENE_WGAME = r10;
        a = new KtvConflictScene[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
    }

    public static KtvConflictScene valueOf(String r1) {
        return (KtvConflictScene) a.a(KtvConflictScene.class, r1);
    }

    public static KtvConflictScene[] values() {
        return (KtvConflictScene[]) a.clone();
    }

    public KtvConflictScene(String r1, int r2) {
        super(r1, r2);
    }
}

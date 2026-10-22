package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import k32.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class AnimPlayer<T extends k32.a> {
    public final InteractivityPlatformContext a;
    public final DataCenter b;

    public static final enum PlayerType extends Enum<PlayerType> {
        public static final PlayerType BigEnterAnim = null;
        public static final PlayerType CustomEnter = null;
        public static final PlayerType DouyinDefault = null;
        public static final PlayerType Ecom = null;
        public static final PlayerType EnterAnim = null;
        public static final PlayerType GameDownLoad = null;
        public static final PlayerType HotsoonDriveEnter = null;
        public static final PlayerType HotsoonDriveWebp = null;
        public static final PlayerType LevelEnter = null;
        public static final PlayerType Mp4EnhancedEnter = null;
        public static final PlayerType OpenAssetVideo = null;
        public static final PlayerType SmallEnterAnim = null;
        public static final PlayerType SpecialEnterAnim = null;
        public static final PlayerType UnKnownEffect = null;
        public static final PlayerType Vigo = null;
        public static final PlayerType WebpEnter = null;
        public static final PlayerType WindScreen = null;
        public static final /* synthetic */ PlayerType[] a = null;

        static {
            PlayerType r0 = new PlayerType("WindScreen", 0);
            WindScreen = r0;
            PlayerType r1 = new PlayerType("Vigo", 1);
            Vigo = r1;
            PlayerType r3 = new PlayerType("SmallEnterAnim", 2);
            SmallEnterAnim = r3;
            PlayerType r5 = new PlayerType("HotsoonDriveEnter", 3);
            HotsoonDriveEnter = r5;
            PlayerType r7 = new PlayerType("DouyinDefault", 4);
            DouyinDefault = r7;
            PlayerType r9 = new PlayerType("UnKnownEffect", 5);
            UnKnownEffect = r9;
            PlayerType r11 = new PlayerType("HotsoonDriveWebp", 6);
            HotsoonDriveWebp = r11;
            PlayerType r13 = new PlayerType("CustomEnter", 7);
            CustomEnter = r13;
            PlayerType r15 = new PlayerType("LevelEnter", 8);
            LevelEnter = r15;
            PlayerType r14 = new PlayerType("WebpEnter", 9);
            WebpEnter = r14;
            PlayerType r16 = new PlayerType("EnterAnim", 10);
            EnterAnim = r16;
            PlayerType r10 = new PlayerType("BigEnterAnim", 11);
            BigEnterAnim = r10;
            PlayerType r8 = new PlayerType("Ecom", 12);
            Ecom = r8;
            PlayerType r6 = new PlayerType("GameDownLoad", 13);
            GameDownLoad = r6;
            PlayerType r4 = new PlayerType("SpecialEnterAnim", 14);
            SpecialEnterAnim = r4;
            PlayerType r2 = new PlayerType("OpenAssetVideo", 15);
            OpenAssetVideo = r2;
            PlayerType r17 = new PlayerType("Mp4EnhancedEnter", 16);
            Mp4EnhancedEnter = r17;
            a = new PlayerType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r16, r10, r8, r6, r4, r2, r17};
        }

        public static PlayerType[] values() {
            return (PlayerType[]) a.clone();
        }

        public static PlayerType valueOf(String r1) {
            return (PlayerType) r27.a.a(PlayerType.class, r1);
        }

        public PlayerType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static class a {
        public final int a;
        public final long b;

        @Nullable
        public final View.OnClickListener c;

        public a(int r1, long r2, @Nullable v72.c r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }
    }

    public boolean a(k32.d r1) {
        return true;
    }

    public abstract void b(@Nonnull T r1, @Nonnull Context r2, @Nonnull a r3, @Nonnull ViewGroup r4, @Nonnull com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r5);

    @Nonnull
    public abstract PlayerType getType();

    public final boolean c() {
        InteractivityPlatformContext r0 = this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isShopShow();
    }

    public AnimPlayer(InteractivityPlatformContext r1, DataCenter r2) {
        this.a = r1;
        this.b = r2;
    }
}

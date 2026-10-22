package com.bytedance.android.live.liveinteract.digitavatar;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.Metadata;
import kotlin.text.CharsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class DigitAvatarMsgController {
    public final Handler a;
    public com.bytedance.android.live.pushstream.d b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/digitavatar/DigitAvatarMsgController$AvatarStickerType;", "", "Recognition", "DigitAvatar", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum AvatarStickerType extends Enum<AvatarStickerType> {
        public static final AvatarStickerType DigitAvatar = null;
        public static final AvatarStickerType Recognition = null;
        public static final /* synthetic */ AvatarStickerType[] a = null;

        static {
            AvatarStickerType r1 = new AvatarStickerType("Recognition", 0);
            Recognition = r1;
            AvatarStickerType r2 = new AvatarStickerType("DigitAvatar", 1);
            DigitAvatar = r2;
            a = new AvatarStickerType[]{r1, r2};
        }

        public static AvatarStickerType valueOf(String r1) {
            return (AvatarStickerType) r27.a.a(AvatarStickerType.class, r1);
        }

        public static AvatarStickerType[] values() {
            return (AvatarStickerType[]) a.clone();
        }

        public AvatarStickerType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public DigitAvatarMsgController(com.bytedance.android.live.pushstream.d r2) {
        this.b = r2;
        this.a = new Handler(Looper.getMainLooper());
    }

    public final void b(int r6, float r7) {
        JSONArray r0 = new JSONArray();
        r0.put(0);
        r0.put(r6);
        r0.put(0);
        JSONArray r2 = new JSONArray();
        r2.put(0);
        r2.put(0);
        r2.put(0);
        JSONObject r3 = new JSONObject();
        r3.put("position", r0);
        r3.put("orientation", r2);
        r3.put("scale", Float.valueOf(r7));
        String r1 = r3.toString();
        ALogger.i("KtvDigitAvatar", "向effect发送调整相机位置指令 position=[0, " + r6 + ", 0], scale=" + r7);
        a(206, 0, r1);
    }

    public final void a(int r4, int r5, String r6) {
        ALogger.i("KtvDigitAvatar", "向Effect的消息：msgType=0x" + Integer.toString(8192, CharsKt.checkRadix(16)) + ", arg1=" + r4 + ", arg2=" + r5 + ", arg3=" + r6);
        com.bytedance.android.live.pushstream.d r0 = this.b;
        if (r0 == null) goto L6;
        r0.i0(r4, r5, r6);
        return;
    }
}

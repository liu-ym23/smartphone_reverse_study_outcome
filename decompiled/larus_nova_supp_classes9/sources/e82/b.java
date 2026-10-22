package e82;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.imagerecognition.StreamRecognitionResponse;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionBusiness;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import com.bytedance.android.livesdkapi.imagerecognition.ScaleConfig;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.bullet.assembler.settings.BulletMixSwitch;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements ImageRecognitionBusiness {
    public b() {
    }

    public final ScaleConfig getScaleConfig() {
        return s32.b.d(2);
    }

    public final ImageRecognitionButton provide(ImageRecognitionEntry r2) {
        Intrinsics.checkNotNullParameter(r2, "entry");
        return new d(r2);
    }

    public final void onInjectExtra(Context r5, ImageRecognitionEntry r6, StreamRecognitionResponse r7, Map<String, Object> r8) {
        Intrinsics.checkNotNullParameter(r6, "entry");
        Intrinsics.checkNotNullParameter(r7, "res");
        Intrinsics.checkNotNullParameter(r8, "extra");
        r8.put("enter_from", "ecom_photo_search_find_similar_live_identify_prod");
        int r9 = a.a[r6.ordinal()];
        if (r9 != 1) goto L5;
        Object r10 = "ecom_photo_search_live_identify_prod_long_press";
    L9:
        r8.put("search_entrance", r10);
        r8.put("search_channel", "ecom_multi_modality_search");
        String r11 = r7.containerSchema;
        Room r13 = null;
        if (r11 == null) goto L12;
        Uri r14 = UriProtector.parse(r11);
    L13:
        if (r14 != null) goto L15;
    L19:
        RoomContext r15 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r15 == null) goto L24;
        m r16 = r15.getRoom();
        if (r16 == null) goto L24;
        r13 = (Room) r16.getValue();
    L24:
        String r17 = "0";
        if (r13 == null) goto L28;
        Object r18 = String.valueOf(r13.getRoomId());
        if (r18 == null) goto L28;
    L29:
        r8.put("room_id", r18);
        HashMap r19 = new HashMap();
        if (r13 == null) goto L33;
        String r2 = String.valueOf(r13.getRoomId());
        if (r2 == null) goto L33;
    L34:
        r19.put("room_id", r2);
        if (r13 == null) goto L40;
        String r1 = r13.getOwnerUserIdString();
        if (r1 == null) goto L40;
        r17 = r1;
    L40:
        r19.put("author_id", r17);
        if (r13 == null) goto L46;
        User r20 = r13.getOwner();
        if (r20 == null) goto L46;
        String r21 = r20.getCastSecUid();
        if (r21 == null) goto L46;
    L47:
        r19.put("anchor_sec_id", r21);
        Unit r23 = Unit.INSTANCE;
        r8.put("extra", r19);
        return;
    L46:
        r21 = BuildConfig.FLAVOR;
    L33:
        r2 = "0";
    L28:
        r18 = "0";
        goto L29
    L15:
        if (h7.b.c(r5, r14, BulletMixSwitch.ContainerType.POPUP) == false) goto L17;
        Object r24 = "AnnieX Live Dialog";
    L18:
        r8.put("dialog_tag", r24);
        goto L19
    L17:
        r24 = "Annie Dialog";
        goto L18
    L12:
        r14 = null;
        goto L13
    L5:
        if (r9 == 2) goto L7;
        r10 = CardLockInfo.sUNKNOWN;
        goto L9
    L7:
        r10 = "ecom_photo_search_live_identify_prod_clear_screen";
        goto L9
    }
}

package s32;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.d8;
import com.bytedance.android.livesdk.config.e8;
import com.bytedance.android.livesdk.config.y00;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.StreamRecognitionCandidate;
import com.bytedance.android.livesdkapi.depend.model.live.StreamRecognitionContainers;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionBusiness;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import com.bytedance.android.livesdkapi.imagerecognition.ScaleConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static ImageRecognitionButton b(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        RoomAuthStatus r0 = z.o(r2).getRoomAuthStatus();
        if (r0 != null) goto L5;
    L7:
        e("RoomAuth", ImageRecognitionEntry.ClearScreen);
        return null;
    L5:
        if (r0.isEnableClearEntranceOption() != true) goto L7;
        return a(r2, ImageRecognitionEntry.ClearScreen);
    }

    public static ImageRecognitionButton c(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        RoomAuthStatus r0 = z.o(r2).getRoomAuthStatus();
        if (r0 != null) goto L5;
    L7:
        e("RoomAuth", ImageRecognitionEntry.LongPressPanel);
        return null;
    L5:
        if (r0.isEnableLongPressOption() != true) goto L7;
        return a(r2, ImageRecognitionEntry.LongPressPanel);
    }

    public static ScaleConfig d(int r4) {
        Map r0 = ((d8) y00.a.getValue()).e();
        if (r0 == null) goto L7;
        e8 r5 = (e8) r0.get(Integer.valueOf(r4));
        if (r5 == null) goto L7;
        return new ScaleConfig(r5.d(), r5.b(), r5.a(), r5.c());
    L7:
        return null;
    }

    public static ImageRecognitionButton a(DataCenter r6, ImageRecognitionEntry r7) {
        IUserService r0 = k.f(IUserService.class);
        if (r0 == null) goto L50;
        com.bytedance.android.livesdk.user.f r1 = r0.user();
        if (r1 == null) goto L50;
        if (r1.isLogin() != true) goto L50;
        boolean r2 = false;
        if (((Number) r6.get("data_link_state", 0)).intValue() <= 2) goto L13;
        e("link state", r7);
        return null;
    L13:
        d8 r3 = (d8) y00.a.getValue();
        List r4 = r3.f();
        if (r4 != null) goto L17;
        r4 = CollectionsKt.emptyList();
    L17:
        if (r3.a() == true) goto L20;
        e(com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_SETTING, r7);
        return null;
    L20:
        RoomOthersData r8 = z.o(r6).others;
        if (r8 == null) goto L25;
        StreamRecognitionContainers r9 = r8.getRecognitionContainers();
        if (r9 == null) goto L25;
        List r10 = r9.recognitionCandidates;
    L26:
        List r5 = r10;
        if (r5 != null) goto L29;
    L30:
        r2 = true;
    L31:
        if (r2 == false) goto L34;
        e("no server data", r7);
        return null;
    L34:
        Iterator r11 = r10.iterator();
    L36:
        if (r11.hasNext() == false) goto L48;
        StreamRecognitionCandidate r13 = (StreamRecognitionCandidate) r11.next();
        if (r4.contains(Integer.valueOf(r13.scene)) == true) goto L39;
        Map<Integer, ImageRecognitionBusiness> r14 = c.a;
        int r15 = r13.scene;
        ImageRecognitionBusiness r16 = (ImageRecognitionBusiness) ((HashMap) c.a).get(Integer.valueOf(r15));
        if (r16 == null) goto L43;
        ImageRecognitionButton r17 = r16.provide(r7);
    L44:
        if (r17 == null) goto L36;
        if (r17.canShow() != true) goto L36;
        return r17;
    L43:
        r17 = null;
        goto L44
    L39:
        e("in block list", r7);
        goto L36
    L48:
        e("no available candidate. candidate num is " + r10.size(), r7);
        return null;
    L29:
        if (r5.isEmpty() == false) goto L31;
    L25:
        r10 = null;
    L50:
        e("not login", r7);
        return null;
    }

    public static void e(String r2, ImageRecognitionEntry r3) {
        int r0 = f.a;
        f.a("disabled entry=" + r3 + " reason=" + r2);
    }
}

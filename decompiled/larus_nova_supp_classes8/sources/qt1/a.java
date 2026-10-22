package qt1;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.config.Cif;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IPlayerLogger;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Map a(FragmentActivity r10, Room r11) {
        HashMap r0 = new HashMap();
        IUserService r1 = k.f(IUserService.class);
        String r2 = "";
        if (r1 == null) goto L8;
        f r3 = r1.user();
        if (r3 == null) goto L8;
        String r4 = r3.n();
        if (r4 == null) goto L8;
    L9:
        r0.put("user_id", r4);
        IHostContext r5 = k.f(IHostContext.class);
        if (r5 == null) goto L13;
        String r6 = r5.getServerDeviceId();
        if (r6 == null) goto L13;
    L14:
        r0.put("device_id", r6);
        if (r11 == null) goto L20;
        String r7 = r11.getIdStr();
        if (r7 == null) goto L20;
        r2 = r7;
    L20:
        r0.put("room_id", r2);
        String r8 = null;
        if (r11 == null) goto L23;
        Long r9 = Long.valueOf(r11.getLiveRoomMode());
    L24:
        r0.put("room_type", r9);
        StringBuilder r12 = new StringBuilder("stream-");
        if (r11 == null) goto L27;
        r8 = r11.getStreamIdStr();
    L27:
        r12.append(r8);
        r0.put("stream_name", r12.toString());
        Object r13 = r10.getSystemService(DataType.AUDIO);
        if (r13 == null) goto L60;
        AudioManager r14 = (AudioManager) r13;
        boolean r15 = false;
        if (Build.VERSION.SDK_INT < 23) goto L32;
        AudioDeviceInfo[] r16 = r14.getDevices(2);
        int r17 = r16.length;
        int r18 = 0;
    L37:
        if (r18 >= r17) goto L50;
        AudioDeviceInfo r19 = r16[r18];
        if (r19.getType() == 3) goto L48;
        if (r19.getType() == 4) goto L48;
        if (r19.getType() == 8) goto L48;
        if (r19.getType() == 7) goto L48;
        r18 = r18 + 1;
    L48:
        r15 = true;
    L50:
        if (r15 == false) goto L52;
        String r20 = "1";
    L53:
        r0.put("headset", r20);
        r0.put("feed_stream", "0");
        Object r110 = r10.getSystemService(DataType.AUDIO);
        if (r110 == null) goto L58;
        AudioManager r111 = (AudioManager) r110;
        r0.put("volume_level", String.valueOf(r111.getStreamVolume(3) / r111.getStreamMaxVolume(3)));
        return r0;
    L58:
        throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
    L52:
        r20 = "0";
        goto L53
    L32:
        if (r14.isWiredHeadsetOn() == true) goto L50;
        if (r14.isBluetoothScoOn() == true) goto L50;
        r14.isBluetoothA2dpOn();
        goto L50
    L60:
        throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
    L23:
        r9 = null;
    L13:
        r6 = "";
    L8:
        r4 = "";
        goto L9
    }

    public static void b(Room r6, Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        boolean r0 = false;
        if (r6 == null) goto L9;
        ILivePlayerClient r2 = LivePlatformPlayerManager.a(r6.getRoomId(), false);
        if (r2 == null) goto L9;
        IPlayerLogger r3 = r2.logger();
        if (r3 == null) goto L9;
        r3.feedbackException("mixed_audio", "", null);
    L9:
        FragmentActivity r8 = ContextUtil.contextToFragmentActivity(r7);
        if (r8 == null) goto L37;
        String r4 = Cif.a.getValue().a();
        if (r4 != null) goto L14;
    L15:
        r0 = true;
    L16:
        if (r0 == false) goto L39;
        ALogger.d("AudioFeedbackAction", "the audio feedback dialog schema is null or empty");
        if (v.a() == true) goto L21;
        return;
    L21:
        throw new IllegalArgumentException("the audio feedback dialog schema is null or empty");
    L39:
        Uri.Builder r1 = UriProtector.parse(r4).buildUpon();     // Catch: Exception -> L32
        Iterator r9 = ((HashMap) a(r8, r6)).entrySet().iterator();     // Catch: Exception -> L32
    L24:
        if (r9.hasNext() == false) goto L28;
        Map.Entry r5 = (Map.Entry) r9.next();     // Catch: Exception -> L32
        String r10 = (String) r5.getKey();     // Catch: Exception -> L32
        Object r11 = r5.getValue();     // Catch: Exception -> L32
        if (r11 == null) goto L24;
        r1.appendQueryParameter(r10, r11.toString());     // Catch: Exception -> L32
        goto L24
    L28:
        Uri r12 = r1.build();     // Catch: Exception -> L32
        ALogger.d("AudioFeedbackAction", "the final schema is " + r12);
        HybridDialog r13 = k.n(IBrowserService.class).showHybridDialog(r8, r12, null);
        if (r13 == null) goto L37;
        ALogger.d("AudioFeedbackAction", "the audioFeedback dialog is " + r13);
        return;
    L32:
        e = move-exception;
        ALogger.e("AudioFeedbackAction", "parse audio feedback dialog schema fail.the uri is " + r4, e);
        if (v.a() == true) goto L36;
        return;
    L36:
        throw e;
    L14:
        if (r4.length() != 0) goto L16;
    L37:
        ALogger.d("AudioFeedbackAction", "the context is null");
    }
}

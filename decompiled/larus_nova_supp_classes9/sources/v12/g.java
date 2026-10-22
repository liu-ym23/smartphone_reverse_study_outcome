package v12;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftStrategy;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g {
    public final long a;
    public final SendGiftSource b;
    public final String c;
    public final String d;
    public final int e;
    public final int f;
    public final boolean g;
    public final SendGiftStrategy h;
    public final int i;
    public final boolean j;
    public final long k;
    public final int l;
    public final boolean m;
    public final String n;
    public final List<IBaseUser> o;
    public final h1 p;
    public final String q;
    public final JSONObject r;
    public final Map<String, Boolean> s;

    public g(long r9, SendGiftSource r11, String r13, String r14, int r15, int r16, boolean r17, SendGiftStrategy r18, int r19, boolean r110, long r20, int r23, boolean r24, String r25, List<? extends IBaseUser> r26, h1 r27, String r28, JSONObject r29, Map<String, Boolean> r210) {
        Intrinsics.checkNotNullParameter(r11, "sendGiftFrom");
        Intrinsics.checkNotNullParameter(r13, "toUserId");
        Intrinsics.checkNotNullParameter(r14, "toRoomId");
        Intrinsics.checkNotNullParameter(r18, "sendGiftStrategy");
        Intrinsics.checkNotNullParameter(r25, "extra");
        this.a = r9;
        this.b = r11;
        this.c = r13;
        this.d = r14;
        this.e = r15;
        this.f = r16;
        this.g = r17;
        this.h = r18;
        this.i = r19;
        this.j = r110;
        this.k = r20;
        this.l = r23;
        this.m = r24;
        this.n = r25;
        this.o = r26;
        this.p = r27;
        this.q = r28;
        this.r = r29;
        this.s = r210;
    }
}

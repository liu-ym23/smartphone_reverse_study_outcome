package b5b;

import a5b.h;
import a5b.i;
import com.ss.android.lark.chat.cot.CotBlockStatus;
import com.ss.android.lark.chat.cot.CotViewBlockType;
import com.ss.android.lark.chat.entity.message.CotEvent;
import com.ss.android.lark.chat.entity.message.CotEventType;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements a5b.b {
    public static final a a = null;
    public static final Set<CotEventType> b = null;

    /* JADX INFO: renamed from: b5b.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0010a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CotEventType.values().length];
            r0[CotEventType.CUSTOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public a() {
    }

    static {
        a = new a();
        b = SetsKt.setOf(new CotEventType[]{CotEventType.RAW, CotEventType.CUSTOM, CotEventType.STATE_DELTA, CotEventType.ACTIVITY_DELTA, CotEventType.UNKNOWN});
    }

    @Override // a5b.b
    public final Set<CotEventType> a() {
        return b;
    }

    @Override // a5b.b
    public final void b(a5b.d r7, CotEvent r8, JSONObject r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "event");
        Intrinsics.checkNotNullParameter(r9, "json");
        boolean r2 = true;
        if (C0010a.a[r8.getEventType().ordinal()] != 1) goto L5;
        CotViewBlockType r1 = CotViewBlockType.CUSTOM;
    L6:
        Intrinsics.checkNotNullParameter(r8, "event");
        Intrinsics.checkNotNullParameter(r1, IPortraitService.TYPE);
        String r11 = r8.getEventId();
        if (r11.length() != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        r11 = String.valueOf(r10);
    L12:
        String r12 = r1.name().toLowerCase(Locale.ROOT) + ':' + r11 + ':' + r10;
        LinkedHashMap<String, h> r13 = r7.b;
        h r14 = r13.get(r12);
        if (r14 != null) goto L22;
        int r15 = a5b.d.a.a[r1.ordinal()];
        if (r15 != 1) goto L17;
        r14 = new i(r12);
    L21:
        r13.put(r12, r14);
        goto L22
    L17:
        if (r15 == 2) goto L19;
        r14 = new i(r12);
        goto L21
    L19:
        r14 = new a5b.g(r12);
    L22:
        h r16 = r14;
        String r17 = a5b.e.d(r9);
        if (r17 != null) goto L26;
        r17 = BuildConfig.FLAVOR;
    L26:
        if (r17.length() > 0) goto L29;
        r2 = false;
    L29:
        if (r2 == false) goto L31;
        r16.d.append(r17);
    L31:
        r16.b(CotBlockStatus.DONE);
        r16.f = false;
        return;
    L9:
        r0 = false;
        goto L10
    L5:
        r1 = CotViewBlockType.RAW;
        goto L6
    }
}

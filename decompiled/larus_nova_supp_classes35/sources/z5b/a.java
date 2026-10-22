package z5b;

import com.ss.android.lark.biz.im.extension.message_action.FeatureScopeInterceptorType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mya.o;
import w4b.d0;
import yya.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements e {
    public static final List<MessageActionType> a = null;

    /* JADX INFO: renamed from: z5b.a$a, reason: collision with other inner class name */
    public static final class C0325a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MessageActionType.values().length];
            r0[MessageActionType.DELETE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[MessageActionType.COPY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[MessageActionType.ZONE_COPY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[MessageActionType.HYPER_TRANSLATE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[MessageActionType.ZONE_HYPER_TRANSLATE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public a() {
    }

    static {
        a = CollectionsKt.listOf(new MessageActionType[]{MessageActionType.REPLY, MessageActionType.ZONE_REPLY, MessageActionType.ADD_FLAG, MessageActionType.ADD_TO_FAVORITE, MessageActionType.PIN, MessageActionType.CHAT_PIN, MessageActionType.RECALL, MessageActionType.ADD_TASK});
    }

    public final String getTAG() {
        return e.a.a(this);
    }

    public FeatureScopeInterceptorType getType() {
        return FeatureScopeInterceptorType.COMMON;
    }

    public final boolean a(MessageActionType r8, yya.a r9) {
        Intrinsics.checkNotNullParameter(r8, "actionType");
        Intrinsics.checkNotNullParameter(r9, "actionContext");
        Chatter r0 = r9.q();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L19;
        if ((r9 instanceof x2b.a) == false) goto L16;
        o r2 = ((x2b.a) r9).a().j5().b(o.class);
        if (r2 == null) goto L16;
        if (r2.i() != true) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == true) goto L19;
    L28:
        v5b.c r4 = r9.m();
        if ((r4 instanceof y6b.c) == false) goto L31;
        y6b.c r5 = (y6b.c) r4;
    L32:
        if (r5 != null) goto L36;
        Log.i("CommonMessageActionInterceptor", "message vo is not a ChatMessageVO, just return");
        return false;
    L36:
        if (r9.m().getType() != Message.Type.UNKNOWN) goto L38;
    L85:
        return true;
    L38:
        if (r5.j() == true) goto L85;
        boolean r10 = r5.Y;
        if (r10 == true) goto L85;
        if (r5.y == true) goto L85;
        if (r5.z == true) goto L85;
        d0 r6 = b7b.b.a;
        if (r10 == true) goto L53;
        long r7 = r5.Z;
        if (r7 > 0) goto L50;
    L52:
        boolean r11 = false;
    L54:
        if (r11 == true) goto L85;
        if (r5.j == true) goto L85;
        if (r5.I == true) goto L85;
        if (r5.isPreMessage() == false) goto L80;
        int r12 = b.a[r8.ordinal()];
        if (r12 != 1) goto L65;
        return false;
    L65:
        if (r12 == 2) goto L74;
        if (r12 == 3) goto L74;
        if (r12 != 4) goto L71;
        return false;
    L71:
        if (r12 == 5) goto L88;
    L77:
        return true;
    L88:
        return false;
    L74:
        if (r5.getType() != Message.Type.TEXT) goto L76;
        return false;
    L76:
        if (r5.getType() != Message.Type.POST) goto L77;
        return false;
    L80:
        if (r5.U == true) goto L82;
        return false;
    L82:
        if (r8 == MessageActionType.DELETE) goto L92;
        return true;
    L92:
        return false;
    L50:
        if (r7 > b7b.b.a.a()) goto L52;
    L53:
        r11 = true;
        goto L54
    L31:
        r5 = null;
    L16:
        r3 = false;
    L19:
        if (a.contains(r8) == false) goto L22;
        return true;
    L22:
        if (r9.m().getType() != Message.Type.AUDIO) goto L28;
        if (r8 != MessageActionType.FORWARD) goto L26;
    L27:
        return true;
    L26:
        if (r8 != MessageActionType.MULTI_SELECT) goto L28;
    L5:
        if (r0.isDimission() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final boolean b(MessageActionType r1, yya.a r2) {
        e.a.c(r1, r2);
        return false;
    }

    public final boolean c(MessageActionType r1, yya.a r2, boolean r3) {
        e.a.b(r1, r2);
        return false;
    }
}

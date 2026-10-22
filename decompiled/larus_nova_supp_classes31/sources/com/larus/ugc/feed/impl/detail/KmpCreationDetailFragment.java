package com.larus.ugc.feed.impl.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.creation.UserCreation;
import com.larus.ugc.feed.api.model.CreationFeedTrackParamsKmp;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import k1a.b;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import xt7.d;
import zp9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/larus/ugc/feed/impl/detail/KmpCreationDetailFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "getUserCreation", "()Lcom/larus/platform/api/creation/UserCreation;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "parseTrackParams", "Lcom/larus/ugc/feed/api/model/CreationFeedTrackParamsKmp;", "Companion", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class KmpCreationDetailFragment extends Fragment {
    public static final /* synthetic */ int d = 0;

    public static final class a {
    }

    static {
    }

    public KmpCreationDetailFragment() {
    }

    public final void onViewCreated(View r32, Bundle r33) {
        Intrinsics.checkNotNullParameter(r32, "view");
        super.onViewCreated(r32, r33);
        Bundle r0 = getArguments();
        Integer r4 = null;
        if (r0 == null) goto L19;
        String r1 = r0.getString("creation");
        if (r1 == null) goto L19;
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L19;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L13
        Object r2 = Result.constructor-impl((UserCreation) d.b.c(UserCreation.Companion.serializer(), r1));     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r2) == false) goto L18;
        r2 = null;
    L18:
        UserCreation r7 = (UserCreation) r2;
    L20:
        FLogger r3 = FLogger.a;
        StringBuilder r6 = new StringBuilder("onViewCreated creationId=");
        if (r7 == null) goto L23;
        String r8 = r7.a;
    L24:
        r6.append(r8);
        r3.i("KmpCreationDetailFragment", r6.toString());
        SimpleDraweeView r9 = r32.findViewById(2131368895);
        if (r9 == null) goto L124;
        if (r7 == null) goto L28;
        String r10 = r7.e();
    L29:
        ImageLoaderKt.u(r9, r10, "community_creation_detail_preview");
        goto L124
    L28:
        r10 = null;
    L124:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L37
        Gson r12 = new Gson();     // Catch: Throwable -> L37
        Bundle r13 = getArguments();     // Catch: Throwable -> L37
        if (r13 == null) goto L34;
        String r14 = r13.getString("track_params");     // Catch: Throwable -> L37
    L35:
        Object r15 = Result.constructor-impl((g) r12.fromJson(r14, g.class));     // Catch: Throwable -> L37
    L40:
        if (Result.isFailure-impl(r15) == false) goto L42;
        r15 = null;
    L42:
        g r16 = (g) r15;
        if (r16 == null) goto L46;
        String r17 = r16.a;
        if (r17 == null) goto L46;
    L47:
        String r18 = r17;
        if (r16 == null) goto L50;
        String r19 = r16.b;
    L51:
        if (r16 == null) goto L53;
        String r110 = r16.c;
    L54:
        if (r16 == null) goto L56;
        String r111 = r16.d;
    L57:
        if (r16 == null) goto L59;
        Integer r112 = r16.e;
    L60:
        if (r16 == null) goto L62;
        String r113 = r16.f;
    L63:
        if (r16 == null) goto L65;
        String r114 = r16.g;
    L66:
        if (r16 == null) goto L68;
        String r115 = r16.h;
    L69:
        if (r16 == null) goto L71;
        String r116 = r16.i;
    L72:
        if (r16 == null) goto L74;
        String r117 = r16.j;
    L75:
        if (r16 == null) goto L77;
        Boolean r118 = r16.k;
    L78:
        if (r16 == null) goto L80;
        String r20 = r16.l;
    L81:
        if (r16 == null) goto L83;
        String r21 = r16.m;
    L84:
        if (r16 == null) goto L86;
        String r22 = r16.n;
    L87:
        if (r16 == null) goto L89;
        String r23 = r16.o;
    L90:
        if (r16 == null) goto L92;
        Boolean r24 = r16.p;
    L93:
        if (r16 == null) goto L95;
        String r25 = r16.q;
    L96:
        if (r16 == null) goto L98;
        String r26 = r16.r;
    L99:
        if (r16 == null) goto L101;
        String r27 = r16.s;
    L102:
        if (r16 == null) goto L104;
        String r28 = r16.t;
    L105:
        if (r16 == null) goto L107;
        String r29 = r16.u;
    L108:
        if (r16 == null) goto L110;
        String r30 = r16.v;
    L111:
        CreationFeedTrackParamsKmp r31 = new CreationFeedTrackParamsKmp(r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r118, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
        Bundle r34 = getArguments();
        if (r34 == null) goto L114;
        boolean r35 = r34.getBoolean("open_new_chat_page_on_send", true);
    L115:
        Bundle r36 = getArguments();
        if (r36 == null) goto L118;
        r4 = Integer.valueOf(r36.getInt("creation_dosame_landing_type"));
    L118:
        Integer r37 = r4;
        Bundle r38 = getArguments();
        if (r38 == null) goto L121;
        boolean r119 = r38.getBoolean("is_send_from_detail", false);
    L122:
        final i0a.a r39 = new i0a.a(r31, r7, r35, r37, r119);
        b.a(this, new r0a.a(this, r39));
        return;
    L121:
        r119 = false;
        goto L122
    L114:
        r35 = true;
        goto L115
    L110:
        r30 = null;
        goto L111
    L107:
        r29 = null;
        goto L108
    L104:
        r28 = null;
        goto L105
    L101:
        r27 = null;
        goto L102
    L98:
        r26 = null;
        goto L99
    L95:
        r25 = null;
        goto L96
    L92:
        r24 = null;
        goto L93
    L89:
        r23 = null;
        goto L90
    L86:
        r22 = null;
        goto L87
    L83:
        r21 = null;
        goto L84
    L80:
        r20 = null;
        goto L81
    L77:
        r118 = null;
        goto L78
    L74:
        r117 = null;
        goto L75
    L71:
        r116 = null;
        goto L72
    L68:
        r115 = null;
        goto L69
    L65:
        r114 = null;
        goto L66
    L62:
        r113 = null;
        goto L63
    L59:
        r112 = null;
        goto L60
    L56:
        r111 = null;
        goto L57
    L53:
        r110 = null;
        goto L54
    L50:
        r19 = null;
    L46:
        r17 = "creation_detail";
        goto L47
    L34:
        r14 = null;
    L37:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    L23:
        r8 = null;
    L13:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
    L19:
        r7 = null;
        goto L20
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561998, r3, false);
    }
}

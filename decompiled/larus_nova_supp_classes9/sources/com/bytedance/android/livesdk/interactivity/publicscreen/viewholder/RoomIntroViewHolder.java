package com.bytedance.android.livesdk.interactivity.publicscreen.viewholder;

import am2.x;
import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.live.base.model.message.b4;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.config.gg1;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l;
import com.bytedance.android.livesdk.interactivity.api.settings.config.u0;
import com.bytedance.android.livesdk.interactivity.i;
import com.bytedance.android.livesdk.interactivity.textmessage.model.b0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.ck;
import com.bytedance.android.livesdk.message.model.dk;
import com.bytedance.android.livesdk.q2;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.FlowLayout;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorLocationPoiInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.message.AppointmentInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import g52.e;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import py.r;
import r52.a4;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/viewholder/RoomIntroViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/ui/MessageViewHolder;", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomIntroViewHolder extends MessageViewHolder {
    public static Disposable p;
    public static boolean q;
    public static final int r = 0;
    public static final int s = 0;
    public static final int t = 0;
    public static String u;
    public static final int v = 0;
    public static final a w = null;
    public final ConstraintLayout b;
    public final SimpleDraweeView c;
    public final ViewGroup d;
    public final TextView e;
    public final TextView f;
    public final ViewGroup g;
    public final HSImageView h;
    public final TextView i;
    public long j;
    public b4 k;
    public boolean l;
    public final boolean m;
    public final e52.a n;
    public final DataCenter o;

    public static final class a {
        public a() {
        }

        public static boolean b(ck r7) {
            if (r7 == null) goto L17;
            AnchorLocationPoiInfo r8 = r7.E();
            if (r8 == null) goto L17;
            if (r8.getEnabled() == true) goto L9;
        L11:
            boolean r1 = false;
        L12:
            if (r1 == true) goto L15;
            r8 = null;
        L15:
            if (r8 == null) goto L17;
            return true;
        L9:
            if (r8.getPoiId() <= 0) goto L11;
            r1 = true;
        L17:
            return false;
        }

        @JvmStatic
        public static void d(long r3) {
            LinkedHashMap r0 = new LinkedHashMap();
            r0.put("action_type", "click");
            r0.put("duration", String.valueOf(r3 / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)));
            j0.l().sendLog("livesdk_room_detail_audience_show_duration", r0, new Object[]{IRoom.class, x.class});
        }

        public static void e(ck r2, ImageView r3) {
            if (Intrinsics.areEqual(r2.c, Boolean.TRUE) == false) goto L6;
            r3.setImageResource(2131252899);
            return;
        L6:
            if (Intrinsics.areEqual(r2.c, Boolean.FALSE) == false) goto L10;
            r3.setImageResource(2131252900);
            return;
        }

        public static void c(String r7, String r8, List r9, boolean r10, boolean r11) {
            j0 r0 = j0.l();
            Pair[] r1 = new Pair[7];
            r1[0] = TuplesKt.to("enter_method", "room_introduction");
            r1[1] = TuplesKt.to("appointment_id", r8);
            String r13 = "0";
            if (r11 == false) goto L5;
            Object r5 = "0";
        L6:
            r1[2] = TuplesKt.to("is_able_click", r5);
            if (r11 == false) goto L9;
            String r14 = "booking";
        L10:
            r1[3] = TuplesKt.to("booking_status", r14);
            List r15 = r9;
            if (r15 != null) goto L13;
        L16:
            boolean r16 = true;
        L17:
            if (r16 == true) goto L19;
            String r17 = "multiple";
        L20:
            r1[4] = TuplesKt.to("announce_type", r17);
            IMiddlewareHostBusiness r18 = k.f(IMiddlewareHostBusiness.class);
            if (r18 == null) goto L26;
            Pair r19 = r18.getLivePushOpenType();
            if (r19 == null) goto L26;
            String r20 = (String) r19.getSecond();
            if (r20 == null) goto L26;
        L27:
            r1[5] = TuplesKt.to("push_open_type", r20);
            if (r10 == false) goto L30;
            r13 = "1";
        L30:
            r1[6] = TuplesKt.to("is_anchor", r13);
            r0.sendLog(r7, MapsKt.mutableMapOf(r1), new Object[]{x.class, IRoom.class});
            return;
        L26:
            r20 = BuildConfig.FLAVOR;
            goto L27
        L19:
            r17 = "single";
            goto L20
        L13:
            if (r15.isEmpty() == true) goto L16;
            r16 = false;
            goto L17
        L9:
            r14 = "cancel";
            goto L10
        L5:
            r5 = "1";
            goto L6
        }

        /* JADX WARN: Failed to calculate best type for var: r1v104 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v104 ??, new type: com.bytedance.android.live.base.model.user.User
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 7 more
         */
        /* JADX WARN: Failed to calculate best type for var: r1v104 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v104 ??, new type: com.bytedance.android.live.base.model.user.User
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 8 more
         */
        /* JADX WARN: Failed to calculate best type for var: r1v56 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v56 ??, new type: com.bytedance.android.live.base.model.user.User
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 7 more
         */
        /* JADX WARN: Failed to calculate best type for var: r1v56 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v56 ??, new type: com.bytedance.android.live.base.model.user.User
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 6 more
         */
        /* JADX WARN: Failed to calculate best type for var: r1v56 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v56 ??, new type: com.bytedance.android.live.base.model.user.User
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 8 more
         */
        /* JADX WARN: Failed to calculate best type for var: r1v56 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v56 ??, new type: com.bytedance.android.live.base.model.user.User
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 7 more
         */
        /* JADX WARN: Failed to calculate best type for var: r1v57 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v57 ??, new type: com.bytedance.android.live.base.model.user.User
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 7 more
         */
        /* JADX WARN: Failed to calculate best type for var: r1v57 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v57 ??, new type: com.bytedance.android.live.base.model.user.User
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 6 more
         */
        /* JADX WARN: Failed to calculate best type for var: r1v57 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v57 ??, new type: com.bytedance.android.live.base.model.user.User
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 8 more
         */
        /* JADX WARN: Failed to calculate best type for var: r1v57 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v57 ??, new type: com.bytedance.android.live.base.model.user.User
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 7 more
         */
        /* JADX WARN: Failed to calculate best type for var: r1v58 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v58 ??, new type: com.bytedance.android.live.base.model.user.User
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 7 more
         */
        /* JADX WARN: Failed to calculate best type for var: r1v58 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v58 ??, new type: com.bytedance.android.live.base.model.user.User
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 6 more
         */
        /* JADX WARN: Failed to calculate best type for var: r1v58 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v58 ??, new type: com.bytedance.android.live.base.model.user.User
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 8 more
         */
        /* JADX WARN: Failed to calculate best type for var: r1v58 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v58 ??, new type: com.bytedance.android.live.base.model.user.User
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 7 more
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v104 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v20 */
        /* JADX WARN: Type inference failed for: r1v43 */
        /* JADX WARN: Type inference failed for: r1v56 */
        /* JADX WARN: Type inference failed for: r1v57, types: [com.bytedance.android.live.base.model.user.User] */
        /* JADX WARN: Type inference failed for: r1v58, types: [com.bytedance.android.live.base.model.user.User] */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v29 */
        /* JADX WARN: Type inference failed for: r2v30 */
        /* JADX WARN: Type inference failed for: r2v31 */
        /* JADX WARN: Type inference failed for: r2v7, types: [android.widget.LinearLayout] */
        /* JADX WARN: Type inference failed for: r2v8, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r36v0, types: [g52.e] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [android.view.ViewGroup] */
        /* JADX WARN: Type inference failed for: r3v9 */
        @JvmStatic
        public static void a(final b4 r30, View r31, SimpleDraweeView r33, ViewGroup r34, TextView r35, TextView r36, e r37, boolean r38, e52.a r39, ViewGroup r310, HSImageView r40, TextView r41, DataCenter r43) {
            Intrinsics.checkNotNullParameter(r30, "data");
            Intrinsics.checkNotNullParameter(r31, "itemView");
            if (r33 != null) goto L5;
            SimpleDraweeView r10 = (SimpleDraweeView) r31.findViewById(2131389468);
        L7:
            if (r34 != null) goto L9;
            ?? r3 = (ViewGroup) r31.findViewById(2131388161);
        L11:
            if (r35 != null) goto L13;
            TextView r11 = (TextView) r31.findViewById(2131388525);
        L14:
            if (r36 != null) goto L16;
            TextView r5 = (TextView) r31.findViewById(2131388397);
        L17:
            if (r310 != null) goto L19;
            ViewGroup r6 = (ViewGroup) r31.findViewById(2131382547);
        L20:
            if (r40 != null) goto L22;
            HSImageView r13 = (HSImageView) r31.findViewById(2131382634);
        L23:
            if (r41 != null) goto L25;
            TextView r14 = (TextView) r31.findViewById(2131382508);
        L26:
            View r15 = r31.findViewById(2131363203);
            ImageView r16 = (ImageView) r31.findViewById(2131387588);
            View r17 = r31.findViewById(2131369197);
            TextView r2 = (TextView) r31.findViewById(2131363216);
            if (r10 == null) goto L33;
            IBaseUser r18 = r30.getUser();
            if (r18 == null) goto L31;
            String r1 = r18.getNickName();
        L32:
            r10.setContentDescription(r1);
            goto L33
        L31:
            r1 = null;
        L33:
            i.Companion.getClass();
            i r4 = i.access$getImpl$cp();
            if (r4 != null) goto L40;
            r4 = (i) k.f(i.class);
            if (r4 != null) goto L39;
            r4 = new i();
        L39:
            i.access$setImpl$cp(r4);
        L40:
            py.k r7 = r4.getAvatarForRoomIntroMessage(r30);
            if (r7 != null) goto L44;
            r7 = r30.getAvatar();
        L44:
            if (r7 == null) goto L47;
            int r19 = RoomIntroViewHolder.t;
            a1.x(r10, r7, r19, r19, 0);
        L47:
            int r8 = p52.a.a;
            Intrinsics.checkNotNullParameter(r30, "message");
            List r110 = r30.G1();
            if (r110 == null) goto L56;
            List r9 = r110;
            String r311 = BuildConfig.FLAVOR;
            SimpleDraweeView r27 = r10;
            ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
            Iterator r21 = r9.iterator();
        L51:
            if (r21.hasNext() == false) goto L53;
            r20.add(Integer.valueOf(((r) r21.next()).getType()));
            goto L51
        L53:
            String r23 = CollectionsKt.joinToString$default(r20, "|", null, null, 0, null, null, 62, null);
            if (r23 == null) goto L57;
        L58:
            RoomIntroViewHolder.u = r23;
            List r24 = r110;
            if (r24 != null) goto L61;
        L64:
            boolean r25 = true;
        L66:
            if (r25 == true) goto L68;
            TextView r26 = r2;
            TextView r111 = r14;
            View r28 = r15;
            if ((r31 instanceof ConstraintLayout) == false) goto L83;
            ConstraintSet r29 = new ConstraintSet();
            ConstraintLayout r44 = (ConstraintLayout) r31;
            r29.clone(r44);
            r29.connect(2131389468, 7, 2131388161, 6);
            r29.setHorizontalBias(2131389468, 0.0f);
            int r45 = 2;
            r29.setHorizontalChainStyle(2131389468, 2);
            r29.applyTo(r44);
        L84:
            r3.removeAllViews();
            if ((r3 instanceof FlowLayout) == true) goto L87;
            ?? r46 = 0;
        L88:
            FlowLayout r47 = (FlowLayout) r46;
            if (r47 == null) goto L92;
            r47.setItemSpacing(UtilityKotlinExtentionsKt.i(r45));
            r47.setLineSpacing(UtilityKotlinExtentionsKt.i(3));
        L92:
            if (r110 != null) goto L93;
        L79:
            ViewGroup r210 = r6;
            HSImageView r211 = r13;
            final List r212 = r110;
            if (r37 == 0) goto L123;
            r37.a(r11, false);
        L123:
            r11.setText(r30.g());
            a4 r0 = a4.a;
            if (((u0) r0.getValue()).b() == false) goto L126;
            int r48 = ((u0) r0.getValue()).c();
        L127:
            r11.setMaxLines(r48);
            r11.setEllipsize(TextUtils.TruncateAt.END);
            if (((u0) r0.getValue()).b() == false) goto L138;
            String r49 = r30.g();
            if (r49 != null) goto L132;
        L135:
            boolean r50 = true;
        L136:
            if (r50 == false) goto L138;
            UtilityKotlinExtentionsKt.t(r11);
        L139:
            if (r38 == false) goto L141;
            UtilityKotlinExtentionsKt.w(r5);
        L141:
            l.e(r31, l.a(false, null, r39));
            boolean r112 = r30 instanceof ck;
            if (r112 == false) goto L162;
            ck r51 = (ck) r30;
            dk r53 = r51.d;
            if (r53 == null) goto L162;
            if (r51.H() == false) goto L162;
            if (((u0) r0.getValue()).b() == false) goto L162;
            if (r210 == null) goto L153;
            UtilityKotlinExtentionsKt.w(r210);
        L153:
            ImageLoader.bindImage(r211, r53.a());
            if (r111 == null) goto L156;
            TextView r113 = r111;
            r113.setText(r53.b());
        L157:
            if (r113 == null) goto L162;
            r113.setTextColor(Color.parseColor(r53.c()));     // Catch: Exception -> L160
        L160:
            e = move-exception;
            ALogger.e("RoomIntroViewHolder", "parse poi color error: " + e.getMessage());
            goto L162
        L156:
            r113 = r111;
        L162:
            if (r112 == false) goto L168;
            if (r38 == true) goto L168;
            ck r54 = (ck) r30;
            AppointmentInfo r55 = r54.G();
            if (r55 == null) goto L168;
            if (r2.a(r55.getAppointmentId()) == false) goto L183;
            UtilityKotlinExtentionsKt.w(r17);
            UtilityKotlinExtentionsKt.w(r28);
            if (RoomIntroViewHolder.q == true) goto L182;
            String r56 = r55.getAppointmentId();
            if (r56 != null) goto L176;
            r56 = r311;
        L176:
            List r57 = r55.getScheduledWeekdays();
            Boolean r58 = r54.c;
            if (r58 == null) goto L179;
            boolean r59 = r58.booleanValue();
        L180:
            c("livesdk_live_announce_card_show", r56, r57, r38, r59);
            RoomIntroViewHolder.q = true;
            goto L182
        L179:
            r59 = false;
        L182:
            r26.setText(r55.getScheduledTimeText());
            e(r54, r16);
            int r114 = 0;
            r16.setOnClickListener(new RoomIntroViewHolder$Companion$setAppointmentInfo$1(r55, r30, r38, r16, r43));
        L184:
            if (r38 == false) goto L187;
        L211:
            if (r38 == true) goto L226;
            if (r43 == null) goto L217;
            Room r60 = z.o(r43);
            if (r60 == null) goto L217;
            final ?? r61 = r60.getOwner();
        L218:
            if (r61 != 0) goto L220;
            ALogger.e("RoomIntroViewHolder", "anchor is null");
            goto L226
        L220:
            a4 r63 = a4.a;
            if (((u0) r63.getValue()).b() == false) goto L226;
            if (((u0) r63.getValue()).d() == false) goto L226;
            r31.setOnClickListener(x0.a(new RoomIntroViewHolder$Companion$setClickOpenProfile$1(r212, r30, r61)));
        L217:
            r61 = r2;
        L226:
            if (r27 == null) goto L228;
            com.bytedance.android.live.core.utils.a1.o(r27, UtilityKotlinExtentionsKt.i(6));
        L228:
            com.bytedance.android.live.core.utils.a1.o(r11, r114);
            r11.setPadding(r11.getPaddingLeft(), UtilityKotlinExtentionsKt.i(6), r11.getPaddingRight(), UtilityKotlinExtentionsKt.i(6));
            return;
        L187:
            if (((gg1) q2.a.getValue()).b() == false) goto L211;
            if (r112 == false) goto L211;
            AnchorLocationPoiInfo r64 = ((ck) r30).E();
            if (r64 == null) goto L211;
            if (r64.getEnabled() == true) goto L196;
        L198:
            boolean r65 = false;
        L199:
            if (r65 == true) goto L202;
            r64 = null;
        L202:
            if (r64 == null) goto L211;
            String r66 = r64.getText();
            if (r66 == null) goto L211;
            UtilityKotlinExtentionsKt.w(r17);
            View r67 = r31.findViewById(2131379107);
            if (r67 == null) goto L208;
            UtilityKotlinExtentionsKt.w(r67);
        L208:
            TextView r68 = (TextView) r31.findViewById(2131379109);
            if (r68 == null) goto L211;
            UtilityKotlinExtentionsKt.w(r68);
            r68.setText(r66);
            goto L211
        L196:
            if (r64.getPoiId() <= 0) goto L198;
            r65 = true;
            goto L199
        L183:
            r114 = 0;
            UtilityKotlinExtentionsKt.t(r17);
            UtilityKotlinExtentionsKt.t(r28);
        L168:
            r114 = 0;
            goto L184
        L132:
            if (r49.length() == 0) goto L135;
            r50 = false;
        L138:
            UtilityKotlinExtentionsKt.w(r11);
            goto L139
        L126:
            r48 = 3;
            goto L127
        L93:
            Iterator r69 = r110.iterator();
        L95:
            if (r69.hasNext() == false) goto L79;
            r r70 = (r) r69.next();
            a r115 = RoomIntroViewHolder.w;
            Context r116 = r31.getContext();
            r115.getClass();
            a4 r117 = a4.a;
            if (((u0) r117.getValue()).b() == false) goto L101;
            String r118 = r70.getShowText();
            if (r118 != null) goto L102;
            r118 = r70.getLabelText();
        L102:
            if (r118 != null) goto L104;
            Iterator r213 = r69;
            ViewGroup r214 = r6;
            HSImageView r215 = r13;
            List r216 = r110;
            ?? r71 = 0;
        L118:
            if (r71 == 0) goto L120;
            r3.addView(r71);
        L120:
            r69 = r213;
            r110 = r216;
            r13 = r215;
            r6 = r214;
            goto L95
        L104:
            String r73 = r70.getLabelIconForMessageShow();
            if (r73 != null) goto L107;
        L114:
            r213 = r69;
            r214 = r6;
            r215 = r13;
            r216 = r110;
            TextView r74 = new TextView(r116);
            r74.setBackgroundResource(2131252850);
            r74.setTextColor(ColorProtector.parseColor("#E6FFFFFF"));
            r74.setTextSize(1, 12.0f);
            r74.setLayoutParams(new ViewGroup.LayoutParams(-2, s1.f(19.0f)));
            r74.setPadding(s1.f(4.0f), 0, s1.f(4.0f), 0);
            r74.setGravity(17);
            r74.setText(r118);
            r71 = r74;
            if (((u0) r117.getValue()).b() == false) goto L118;
            r74.setMaxLines(1);
            r74.setEllipsize(TextUtils.TruncateAt.END);
            r71 = r74;
            goto L118
        L107:
            if (TextUtils.isEmpty(r73) == true) goto L114;
            ?? r75 = new LinearLayout(r116);
            r213 = r69;
            r75.setBackgroundResource(2131252850);
            r216 = r110;
            r215 = r13;
            r75.setLayoutParams(new ViewGroup.LayoutParams(-2, s1.f(19.0f)));
            r75.setPadding(s1.f(4.0f), 0, s1.f(4.0f), 0);
            r75.setGravity(16);
            r75.setOrientation(0);
            HSImageView r76 = new HSImageView(r116);
            int r119 = RoomIntroViewHolder.r;
            LinearLayout.LayoutParams r120 = new LinearLayout.LayoutParams(r119, r119);
            r120.rightMargin = RoomIntroViewHolder.s;
            Unit r121 = Unit.INSTANCE;
            r76.setLayoutParams(r120);
            py.k r122 = f.c(py.k.class);
            r214 = r6;
            r122.setUrls(CollectionsKt.mutableListOf(new String[]{r73}));
            ImageUtil.loadImage(r76, r122, 0);
            TextView r77 = new TextView(r116);
            r77.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            r77.setTextColor(ColorProtector.parseColor("#E6FFFFFF"));
            r77.setTextSize(1, 12.0f);
            r77.setText(r118);
            if (((u0) r117.getValue()).b() == false) goto L113;
            r77.setMaxLines(1);
            r77.setEllipsize(TextUtils.TruncateAt.END);
        L113:
            r75.addView(r76, r76.getLayoutParams());
            r75.addView(r77);
            r71 = r75;
            goto L118
        L101:
            r118 = r70.getLabelText();
            goto L102
        L87:
            r46 = r3;
            goto L88
        L83:
            r45 = 2;
            goto L84
        L68:
            if ((r31 instanceof ConstraintLayout) == false) goto L78;
            ConstraintSet r78 = new ConstraintSet();
            r26 = r2;
            ConstraintLayout r79 = (ConstraintLayout) r31;
            r78.clone(r79);
            r111 = r14;
            r28 = r15;
            r78.connect(2131388525, 6, 2131389468, 7);
            r78.connect(2131389468, 7, 2131388525, 6);
            r78.setHorizontalChainStyle(2131389468, 2);
            r78.setHorizontalBias(2131389468, 0.0f);
            r78.connect(2131388525, 7, 2131384828, 7);
            r78.applyTo(r79);
            ViewGroup.LayoutParams r80 = r11.getLayoutParams();
            if (r80 == null) goto L77;
            ConstraintLayout.LayoutParams r81 = (ConstraintLayout.LayoutParams) r80;
            ((ViewGroup.MarginLayoutParams) r81).leftMargin = 0;
            ((ViewGroup.MarginLayoutParams) r81).topMargin = 0;
            r11.setLayoutParams(r81);
            ConstraintLayout.LayoutParams r83 = r3.getLayoutParams();
            if (r83 == null) goto L75;
            ConstraintLayout.LayoutParams r84 = r83;
            ((ViewGroup.MarginLayoutParams) r84).topMargin = 0;
            r3.setLayoutParams(r84);
            goto L79
        L75:
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        L77:
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        L78:
            r26 = r2;
            r111 = r14;
            r28 = r15;
            goto L79
        L61:
            if (r24.isEmpty() == true) goto L64;
            r25 = false;
        L57:
            r23 = r311;
            goto L58
        L56:
            r311 = BuildConfig.FLAVOR;
            r27 = r10;
            goto L57
        L25:
            r14 = r41;
            goto L26
        L22:
            r13 = r40;
            goto L23
        L19:
            r6 = r310;
            goto L20
        L16:
            r5 = r36;
            goto L17
        L13:
            r11 = r35;
            goto L14
        L9:
            r3 = r34;
            goto L11
        L5:
            r10 = r33;
            goto L7
        }
    }

    static {
        w = new a();
        r = s1.f(10.0f);
        s = s1.f(2.0f);
        t = (int) s1.e(20.0f);
        u = BuildConfig.FLAVOR;
        v = 19;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder
    public final void V3() {
        a r0 = w;
        long r1 = SystemClock.elapsedRealtime() - this.j;
        r0.getClass();
        a.d(r1);
        Disposable r2 = p;
        if (r2 == null) goto L5;
        r2.dispose();
    L5:
        q = false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder
    public final void T3() {
        this.j = SystemClock.elapsedRealtime();
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("action_type", "click");
        String r1 = u;
        if (r1 == null) goto L5;
        r0.put("label_tag", r1);
    L5:
        j0.l().sendLog("livesdk_room_detail_audience_show", r0, new Object[]{IRoom.class, x.class});
        if (this.l == true) goto L44;
        this.l = true;
        boolean r2 = this.m;
        List r3 = null;
        String r4 = BuildConfig.FLAVOR;
        if (r2 == false) goto L18;
        LinkedHashMap r5 = new LinkedHashMap();
        int r6 = p52.a.a;
        b4 r7 = this.k;
        if (r7 == null) goto L13;
        r3 = r7.G1();
    L13:
        String r8 = p52.a.b(r3);
        if (r8 == null) goto L17;
        r4 = r8;
    L17:
        r5.put("label_text", r4);
        j0.l().sendLog("livesdk_live_room_detail_anchor_show", r5, new Object[]{IRoom.class});
        return;
    L18:
        LinkedHashMap r9 = new LinkedHashMap();
        IMiddlewareLiveService r10 = k.f(IMiddlewareLiveService.class);
        if (r10 == null) goto L24;
        ILiveOntologyInfoManager r11 = r10.getLiveOntologyRecord();
        if (r11 == null) goto L24;
        String r13 = r11.getEnterFromMerge();
        if (r13 == null) goto L24;
    L25:
        r9.put("drawer_page", r13);
        int r14 = p52.a.a;
        b4 r15 = this.k;
        if (r15 == null) goto L28;
        List r16 = r15.G1();
    L29:
        String r17 = p52.a.b(r16);
        if (r17 == null) goto L33;
        r4 = r17;
    L33:
        r9.put("label_text", r4);
        a r18 = w;
        List r19 = this.k;
        if ((r19 instanceof ck) == false) goto L37;
        r3 = r19;
    L37:
        r18.getClass();
        if (a.b((ck) r3) == false) goto L40;
        String r20 = "1";
    L41:
        r9.put("has_poi", r20);
        j0.l().sendLog("livesdk_live_room_detail_audience_show", r9, new Object[]{x.class, IRoom.class});
        return;
    L40:
        r20 = "0";
        goto L41
    L28:
        r16 = null;
    L24:
        r13 = BuildConfig.FLAVOR;
        goto L25
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder
    public final void U3(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r16, int r17, e r18) {
        if ((r16 instanceof b0) == false) goto L8;
        b4 r1 = ((b0) r16).b;
        if (r1 == null) goto L9;
        b4 r2 = r1;
        this.k = r2;
        a r3 = w;
        ConstraintLayout r4 = this.b;
        SimpleDraweeView r5 = this.c;
        ViewGroup r6 = this.d;
        TextView r7 = this.e;
        TextView r8 = this.f;
        boolean r9 = this.m;
        e52.a r10 = this.n;
        ViewGroup r11 = this.g;
        HSImageView r13 = this.h;
        TextView r14 = this.i;
        DataCenter r15 = this.o;
        r3.getClass();
        a.a(r2, r4, r5, r6, r7, r8, r18, r9, r10, r11, r13, r14, r15);
        return;
    L9:
        return;
    }

    public RoomIntroViewHolder(View r2, boolean r3, q92.a r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r4, "textMessageConfig");
        super(r2);
        this.m = r3;
        this.n = r4;
        this.o = r5;
        ConstraintLayout r6 = r2.findViewById(2131384828);
        this.b = r6;
        this.c = r6.findViewById(2131389468);
        this.d = (ViewGroup) r6.findViewById(2131388161);
        this.e = (TextView) r6.findViewById(2131388525);
        this.f = (TextView) r6.findViewById(2131388397);
        this.g = (ViewGroup) r6.findViewById(2131382547);
        this.h = r6.findViewById(2131382634);
        this.i = (TextView) r6.findViewById(2131382508);
    }
}

package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileBusinessArea;
import com.bytedance.android.live.base.model.user.ProfileOpenArea;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.component.descriptioncomponent.groupmember.GroupLiveMemberDiffCallback;
import com.bytedance.android.live.profile.ui.component.descriptioncomponent.groupmember.HorizontalSpacingItemDecoration;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class z implements com.bytedance.android.live.profile.ui.base.g, qt0.b {
    public MultiTypeAdapter a;
    public List<qt0.a> b;
    public View c;
    public RecyclerView d;
    public TextView e;
    public Disposable f;
    public final HorizontalSpacingItemDecoration g;
    public final HorizontalSpacingItemDecoration h;
    public final Set<String> i;
    public final com.bytedance.android.live.profile.ui.base.h j;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ List a;
        public final /* synthetic */ z b;

        public b(List r1, z r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            DiffUtil.DiffResult r4 = (DiffUtil.DiffResult) r3;
            Intrinsics.checkNotNullParameter(r4, "diffResult");
            List<qt0.a> r0 = this.b.b;
            if (r0 == null) goto L5;
            r0.clear();
        L5:
            List<qt0.a> r1 = this.b.b;
            if (r1 == null) goto L8;
            r1.addAll(this.a);
        L8:
            z r2 = this.b;
            Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L15
            MultiTypeAdapter r6 = r2.a;     // Catch: Throwable -> L15
            if (r6 == null) goto L12;
            r4.dispatchUpdatesTo(r6);     // Catch: Throwable -> L15
            Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L15
        L13:
            Result.constructor-impl(r7);     // Catch: Throwable -> L15
            return;
        L12:
            r7 = null;
        L15:
            th = move-exception;
            Result.Companion r8 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "error");
            Logger.e(r3.getMessage());
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void e(ProfileSkin r1) {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void f() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        Disposable r0 = this.f;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.i.clear();
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.GroupLiveMember.INSTANCE;
    }

    public z(com.bytedance.android.live.profile.profilecontext.a r3) {
        Intrinsics.checkNotNullParameter(r3, "profileContext");
        this.j = r3;
        this.g = new HorizontalSpacingItemDecoration(UtilityKotlinExtentionsKt.i(2) / 2);
        this.h = new HorizontalSpacingItemDecoration(UtilityKotlinExtentionsKt.i(5) / 2);
        this.i = new LinkedHashSet();
    }

    @Override // qt0.b
    public final void a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "uid");
        if (r6.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        String r1 = r6;
    L9:
        if (r1 == null) goto L12;
        UserProfileEvent r3 = new UserProfileEvent(r1);
        r3.setClickUserPosition("profile_group_member");
        r3.setSkipPrivacyCheck(true);
        r3.setSkipExistPanelCheck(true);
        this.j.dismiss();
        xs2.b.a().post(r3);
        this.j.sendLog("livesdk_group_profile_card_member_single", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("group_member_id", r6), TuplesKt.to("event_type", "click")}), new Object[0]);
        return;
    L12:
        return;
    L8:
        r1 = null;
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r4) {
        Context r0 = r4.getContext();
        if (r0 == null) goto L14;
        View r5 = ((com.bytedance.android.live.profile.ui.base.e) r4).f(2131567181, true);
        if (r5 == null) goto L9;
        View r6 = r5.findViewById(2131373980);
        if (r6 == null) goto L9;
        this.d = r6.findViewById(2131373979);
        this.e = (TextView) r6.findViewById(2131373981);
        Unit r1 = Unit.INSTANCE;
    L10:
        this.c = r6;
        LinearLayoutManager r7 = new LinearLayoutManager(r0, 0, false);
        MultiTypeAdapter r2 = new MultiTypeAdapter();
        r2.z2(qt0.a.class, new qt0.c());
        Unit r3 = Unit.INSTANCE;
        this.a = r2;
        RecyclerView r8 = this.d;
        if (r8 == null) goto L15;
        r8.setLayoutManager(r7);
        r8.setAdapter(this.a);
        return;
    L15:
        return;
    L9:
        r6 = null;
        goto L10
    }

    @Override // qt0.b
    public final void c(String r6) {
        Intrinsics.checkNotNullParameter(r6, "uid");
        if (this.i.contains(r6) == false) goto L5;
        return;
    L5:
        this.j.sendLog("livesdk_group_profile_card_member_single", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("group_member_id", r6), TuplesKt.to("event_type", "show")}), new Object[0]);
        this.i.add(r6);
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r2, "user");
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r7) {
        Intrinsics.checkNotNullParameter(r7, "user");
        ProfileOpenArea r8 = r7.openArea;
        if (r8 == null) goto L48;
        ProfileBusinessArea r9 = r8.businessAreaV3;
        if (r9 == null) goto L48;
        com.bytedance.android.live.base.model.user.h r10 = r9.groupLiveBanner;
        if (r10 == null) goto L48;
        List r1 = r10.a();
        if (r1 == null) goto L44;
        List r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        IBaseUser r5 = (IBaseUser) r4.next();
        qt0.a r6 = new qt0.a();
        r6.a = r5.getUserId();
        r6.b = r5.getAvatarThumbKt();
        r6.c = r5.getRealNickName();
        r6.d = Integer.valueOf(h(r10.c()));
        r6.e = this;
        r3.add(r6);
        goto L12
    L14:
        View r12 = this.c;
        if (r12 == null) goto L17;
        r12.setVisibility(0);
    L17:
        i(r10.c());
        String r13 = r10.b();
        Unit r14 = null;
        if (r13 != null) goto L25;
        View r15 = this.c;
        if (r15 == null) goto L24;
        Context r16 = r15.getContext();
        if (r16 == null) goto L24;
        r13 = r16.getString(2131917202);
    L24:
        r13 = null;
    L25:
        if (r13 != null) goto L27;
        r13 = "";
    L27:
        j(r13, r10.c());
        List<qt0.a> r17 = CollectionsKt.toMutableList(r3);
        MultiTypeAdapter r18 = this.a;
        if (r18 == null) goto L30;
        r18.a = r17;
    L30:
        Unit r19 = Unit.INSTANCE;
        this.b = r17;
        if (r18 == null) goto L33;
        r18.notifyItemRangeInserted(0, r3.size());
    L33:
        RecyclerView r20 = this.d;
        if (r20 != null) goto L36;
    L40:
        RecyclerView r22 = this.d;
        if (r22 == null) goto L43;
        r22.invalidateItemDecorations();
        r14 = Unit.INSTANCE;
    L43:
        if (r14 == null) goto L44;
        return;
    L36:
        if (r3.size() <= 5) goto L38;
        HorizontalSpacingItemDecoration r23 = this.g;
    L39:
        r20.addItemDecoration(r23);
        goto L40
    L38:
        r23 = this.h;
    L44:
        View r24 = this.c;
        if (r24 == null) goto L47;
        r24.setVisibility(8);
    L47:
        Unit r25 = Unit.INSTANCE;
        return;
    L48:
        View r26 = this.c;
        if (r26 == null) goto L55;
        r26.setVisibility(8);
        return;
    }

    public final int h(com.bytedance.android.live.base.model.user.i r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        if (r3 == null) goto L6;
        String r4 = r3.c();     // Catch: Throwable -> L9
        if (r4 == null) goto L6;
    L7:
        Object r5 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r4)));     // Catch: Throwable -> L9
    L11:
        Integer r1 = null;
        if (Result.isFailure-impl(r5) == false) goto L14;
        r5 = null;
    L14:
        Integer r6 = (Integer) r5;
        if (r6 != null) goto L23;
        View r7 = this.c;
        if (r7 == null) goto L24;
        Context r8 = r7.getContext();
        if (r8 == null) goto L24;
        Resources r9 = r8.getResources();
        if (r9 == null) goto L24;
        r1 = Integer.valueOf(r9.getColor(2131107010));
    L24:
        if (r1 != null) goto L30;
        return -16777216;
    L30:
        return r1.intValue();
    L23:
        r1 = r6;
    L6:
        r4 = "#161823";
    L9:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void i(com.bytedance.android.live.base.model.user.i r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        View r0 = this.c;
        if (r0 != null) goto L7;
        return;
    L7:
        Drawable r1 = null;
        if (r0 != null) goto L46;
        Drawable r2 = null;
    L14:
        if ((r2 instanceof GradientDrawable) == false) goto L17;
        r1 = r2;
    L17:
        GradientDrawable r3 = (GradientDrawable) r1;     // Catch: Exception -> L10
        if (r3 != null) goto L20;
        return;
    L20:
        r3.mutate();     // Catch: Exception -> L10
        List r4 = r10.b();     // Catch: Exception -> L10
        boolean r5 = true;
        if (r4 == null) goto L32;
        r3.setGradientType(0);     // Catch: Exception -> L10
        r3.setOrientation(GradientDrawable.Orientation.TL_BR);     // Catch: Exception -> L10
        int r6 = r4.size();     // Catch: Exception -> L10
        if (r6 != 2) goto L25;
        r3.setColors(new int[]{Color.parseColor((String) ListProtector.get(r4, 0)), Color.parseColor((String) ListProtector.get(r4, 1))});     // Catch: Exception -> L10
        goto L32
    L25:
        if (r6 != 3) goto L32;
        if (Build.VERSION.SDK_INT < 29) goto L30;
        r3.setColors(new int[]{Color.parseColor((String) ListProtector.get(r4, 0)), Color.parseColor((String) ListProtector.get(r4, 1)), Color.parseColor((String) ListProtector.get(r4, 2))}, new float[]{0.0f, 0.5f, 1.0f});     // Catch: Exception -> L10
        goto L32
    L30:
        r3.setColors(new int[]{Color.parseColor((String) ListProtector.get(r4, 0)), Color.parseColor((String) ListProtector.get(r4, 1)), Color.parseColor((String) ListProtector.get(r4, 2))});     // Catch: Exception -> L10
    L32:
        String r7 = r10.a();     // Catch: Exception -> L10
        if (r7 != null) goto L35;
    L38:
        if (r5 == true) goto L40;
        r3.setStroke((int) UtilityKotlinExtentionsKt.h(0.5f), Color.parseColor(r10.a()));     // Catch: Exception -> L10
    L40:
        View r12 = this.c;     // Catch: Exception -> L10
        if (r12 == null) goto L48;
        r12.setBackground(r3);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        ALogger.e("ProfileGroupLiveMember", "ProfileGroupLiveMemberComponent renderBackground error: " + e.getMessage());
        return;
    L48:
        return;
    L35:
        if (r7.length() == 0) goto L38;
        r5 = false;
        goto L38
    L46:
        r2 = r0.getBackground();     // Catch: Exception -> L10
        goto L14
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r6) {
        Intrinsics.checkNotNullParameter(r6, "newUser");
        ProfileOpenArea r7 = r6.openArea;
        if (r7 == null) goto L57;
        ProfileBusinessArea r8 = r7.businessAreaV3;
        if (r8 == null) goto L57;
        com.bytedance.android.live.base.model.user.h r9 = r8.groupLiveBanner;
        if (r9 == null) goto L57;
        List r1 = r9.a();
        if (r1 == null) goto L54;
        List r2 = r1;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        IBaseUser r4 = (IBaseUser) r3.next();
        qt0.a r5 = new qt0.a();
        r5.a = r4.getUserId();
        r5.b = r4.getAvatarThumbKt();
        r5.c = r4.getRealNickName();
        r5.d = Integer.valueOf(h(r9.c()));
        r5.e = this;
        r0.add(r5);
        goto L12
    L14:
        View r10 = this.c;
        if (r10 == null) goto L17;
        r10.setVisibility(0);
    L17:
        i(r9.c());
        String r12 = r9.b();
        HorizontalSpacingItemDecoration r13 = null;
        if (r12 != null) goto L25;
        View r14 = this.c;
        if (r14 == null) goto L24;
        Context r15 = r14.getContext();
        if (r15 == null) goto L24;
        r12 = r15.getString(2131917202);
    L24:
        r12 = null;
    L25:
        if (r12 != null) goto L27;
        r12 = "";
    L27:
        j(r12, r9.c());
        List<qt0.a> r16 = this.b;
        if (r16 == null) goto L35;
        if (r16.size() <= 5) goto L32;
        HorizontalSpacingItemDecoration r17 = this.g;
    L33:
        r13 = r17;
        goto L35
    L32:
        r17 = this.h;
    L35:
        if (r0.size() <= 5) goto L37;
        HorizontalSpacingItemDecoration r18 = this.g;
    L39:
        if ((!Intrinsics.areEqual(r13, r18)) == false) goto L50;
        if (r13 == null) goto L44;
        RecyclerView r19 = this.d;
        if (r19 == null) goto L44;
        r19.removeItemDecoration(r13);
    L44:
        RecyclerView r20 = this.d;
        if (r20 == null) goto L47;
        r20.addItemDecoration(r18);
    L47:
        RecyclerView r22 = this.d;
        if (r22 == null) goto L50;
        r22.invalidateItemDecorations();
    L50:
        Disposable r23 = this.f;
        if (r23 == null) goto L53;
        r23.dispose();
    L53:
        this.f = Observable.just(DiffUtil.calculateDiff(new GroupLiveMemberDiffCallback(this.b, r0))).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r0, this), c.a);
        return;
    L37:
        r18 = this.h;
        goto L39
    L54:
        View r24 = this.c;
        if (r24 == null) goto L63;
        r24.setVisibility(8);
        return;
    L63:
        return;
    L57:
        View r25 = this.c;
        if (r25 == null) goto L65;
        r25.setVisibility(8);
        return;
    }

    public final void j(String r2, com.bytedance.android.live.base.model.user.i r3) {
        TextView r0 = this.e;
        if (r0 == null) goto L23;
        r0.setText(r2);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L12
        if (r3 == null) goto L9;
        String r5 = r3.d();     // Catch: Throwable -> L12
        if (r5 == null) goto L9;
    L10:
        Object r6 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r5)));     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r6) == false) goto L17;
        r6 = null;
    L17:
        Integer r7 = (Integer) r6;
        if (r7 == null) goto L24;
        r0.setTextColor(r7.intValue());
        return;
    L24:
        return;
    L9:
        r5 = "#161823";
    L12:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }
}

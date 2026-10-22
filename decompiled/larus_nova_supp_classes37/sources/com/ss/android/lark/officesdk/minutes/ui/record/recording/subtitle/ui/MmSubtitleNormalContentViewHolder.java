package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.api.init.IDeviceInfoProvider;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.MmUserInfoHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmDisplaySpeakerEditBackgroundStyle;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmSubtitleSpeakerAvatarView;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0012\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\r2\u0006\u00103\u001a\u000204J\"\u00105\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\r2\n\u00106\u001a\u0006\u0012\u0002\b\u0003072\u0006\u00103\u001a\u000204J\u0016\u00108\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\r2\u0006\u00103\u001a\u000204J\u0010\u00109\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\rH\u0002J\u0010\u0010:\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\rH\u0002J\b\u0010;\u001a\u00020\u000eH\u0002J\u0018\u0010<\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\r2\u0006\u00103\u001a\u000204H\u0002J\u0010\u0010=\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020.H\u0002J\b\u0010?\u001a\u00020\u000eH\u0002J\u0010\u0010@\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020.H\u0002J\u0010\u0010A\u001a\u00020.2\u0006\u00103\u001a\u000204H\u0002J\u0010\u0010D\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\rH\u0002J\u0010\u0010E\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\rH\u0002J\u0010\u0010F\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\rH\u0002J \u0010G\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\r2\u0006\u0010F\u001a\u00020\u00132\u0006\u0010H\u001a\u00020\u0013H\u0002J\u0010\u0010I\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\rH\u0002J\u0010\u0010J\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\rH\u0002J \u0010K\u001a\u00020\u000e2\u0006\u0010L\u001a\u00020M2\u0006\u0010F\u001a\u00020\u00132\u0006\u0010H\u001a\u00020\u0013H\u0002J\u0010\u0010H\u001a\u00020\u000e2\u0006\u0010L\u001a\u00020MH\u0002J\u0018\u0010N\u001a\u00020\u000e2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u0003H\u0002J\u0018\u0010R\u001a\u00020\u000e2\u0006\u0010O\u001a\u00020P2\u0006\u0010S\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleNormalContentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "recordingId", "", "uccApi", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;", "binding", "Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmSubtitleItemNormalViewContract;", "meetingId", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onEditSpeakerClick", "Lkotlin/Function1;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/MmSubtitleItem;", "", "onSubtitleLongClick", "Lkotlin/Function3;", "", "Landroid/view/View;", "", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmSubtitleItemNormalViewContract;Ljava/lang/String;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "colorProvider", "Lcom/ss/android/lark/officesdk/minutes/ui/style/contract/IMmUIColorProvider;", "primaryTextColor", "secondaryTextColor", "defaultUserNameColor", "disabledUserNameColor", "highlightBackgroundColor", "selectedBackgroundColor", "highlightPadding", "highlightHorizontalMargin", "highlightRadius", "", "separatorDrawable", "Landroid/graphics/drawable/Drawable;", "userInfoJob", "Lkotlinx/coroutines/Job;", "currentSpeakerUserId", "exposurePreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "exposedSegId", "", "Ljava/lang/Long;", "currentItem", "highlightBackgroundDrawable", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleHighlightBackgroundDrawable;", "userInfoHelper", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/user/IMmUserInfoHelper;", "bind", "item", "highlightStyle", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleHighlightStyle;", "bindPartial", "payloads", "", "bindHighlightStyle", "bindContent", "bindTime", "bindSeparator", "bindHighlight", "replaceHighlightBackground", "drawable", "clearHighlightBackground", "updateHighlightBackground", "createHighlightBackground", "_dp12", "_dp6", "bindEditState", "bindSpeaker", "bindAvatar", "bindSpeakerInfo", "bindUserName", "scheduleVoicePrintExposure", "reportVoicePrintExposure", "updateSpeakerUI", MmEndWindowAvatar.TYPE_SPEAKER, "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/MmDisplaySpeaker;", "setTextIfChanged", "textView", "Landroid/widget/TextView;", "text", "setTextColorIfChanged", "color", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmSubtitleNormalContentViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int B = 0;
    public final int A;
    public final String a;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a b;
    public final mwb.j c;
    public final String d;
    public final LifecycleOwner e;
    public final Function1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h, Unit> f;
    public final Function3<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h, Integer, View, Boolean> g;
    public final com.ss.android.lark.officesdk.minutes.ui.style.contract.d h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final float q;
    public final Drawable r;
    public Job s;
    public String t;
    public ViewTreeObserver.OnPreDrawListener u;
    public Long v;
    public com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h w;
    public p x;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.a y;
    public final int z;

    public static final class a implements View.OnLongClickListener {
        public final /* synthetic */ MmSubtitleNormalContentViewHolder a;

        public a(MmSubtitleNormalContentViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r5) {
            MmSubtitleNormalContentViewHolder r6 = this.a;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r0 = r6.w;
            if (r0 != null) goto L5;
            return false;
        L5:
            Integer r7 = Integer.valueOf(r6.getBindingAdapterPosition());
            if (r7.intValue() == (-1)) goto L8;
            boolean r2 = true;
        L9:
            if (r2 == true) goto L12;
            r7 = null;
        L12:
            if (r7 == null) goto L15;
            int r8 = r7.intValue();
            return ((Boolean) this.a.g.invoke(r0, Integer.valueOf(r8), this.a.c.b)).booleanValue();
        L15:
            return false;
        L8:
            r2 = false;
            goto L9
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[MmSubtitleHighlightStyle.values().length];
            r0[MmSubtitleHighlightStyle.SELECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L4:
            a = r0;
            int[] r1 = new int[MmDisplaySpeakerEditBackgroundStyle.values().length];
            r1[MmDisplaySpeakerEditBackgroundStyle.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L20:
            r1[MmDisplaySpeakerEditBackgroundStyle.DISABLE_MARKED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            r1[MmDisplaySpeakerEditBackgroundStyle.DISABLE_UNMARKED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L18:
            r1[MmDisplaySpeakerEditBackgroundStyle.EDITABLE_UNMARKED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L22:
            r1[MmDisplaySpeakerEditBackgroundStyle.EDITABLE_MARKED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L10:
            b = r1;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ MmSubtitleNormalContentViewHolder a;
        public final /* synthetic */ p b;

        public c(MmSubtitleNormalContentViewHolder r1, p r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            MmSubtitleNormalContentViewHolder r0 = this.a;
            p r1 = this.b;
            if (r0.x == r1) goto L5;
            return;
        L5:
            if (r0.c.b.getWidth() > 0) goto L8;
            return;
        L8:
            if (r0.c.k.getVisibility() != 0) goto L10;
            int r2 = r0.c.k.getBottom();
        L11:
            int r3 = r0.c.i.getRight();
            int r4 = r0.c.j.getRight();
            if (r0.c.k.getVisibility() != 0) goto L14;
            int r5 = r0.c.k.getRight();
        L15:
            int r6 = Math.max(r4, r5);
            int r7 = Math.min(r0.c.d.getLeft(), r0.c.j.getLeft());
            int r8 = Math.max(r3, r6);
            int r9 = RangesKt.coerceAtLeast(r7 - r0.o, 0);
            int r10 = RangesKt.coerceAtLeast(r0.c.d.getTop() - r0.o, 0);
            r1.c.set(r9, r10, RangesKt.coerceAtMost((r8 - r7) + (r0.o * 2), RangesKt.coerceAtLeast(r0.c.b.getWidth() - r0.p, r9) - r9) + r9, ((r2 - r0.c.d.getTop()) + (r0.o * 2)) + r10);
            r1.invalidateSelf();
            r0.c.b.invalidate();
            return;
        L14:
            r5 = 0;
            goto L15
        L10:
            r2 = r0.c.j.getBottom();
            goto L11
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ MmSubtitleNormalContentViewHolder a;
        public final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h b;

        public d(MmSubtitleNormalContentViewHolder r1, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            if (((RecyclerView.ViewHolder) this.a).itemView.getViewTreeObserver().isAlive() == true) goto L5;
            return true;
        L5:
            Rect r0 = new Rect();
            if (((RecyclerView.ViewHolder) this.a).itemView.isShown() == true) goto L8;
        L14:
            boolean r1 = false;
        L15:
            if (r1 == false) goto L38;
            MmSubtitleNormalContentViewHolder r2 = this.a;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r3 = this.b;
            com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.r r4 = (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.r) r2.b.N().h.getValue();
            String r5 = r2.a;
            String r6 = r2.d;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.i r7 = r3.g;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r8 = r3.h;
            r4.getClass();
            Intrinsics.checkNotNullParameter(r5, "recordingSessionId");
            Intrinsics.checkNotNullParameter(r6, "meetingId");
            Intrinsics.checkNotNullParameter(r7, MmEndWindowAvatar.TYPE_SPEAKER);
            com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r9 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
            r9.e("conference_id", r6);
            r9.e("scene", "subtitle");
            IDeviceInfoProvider r10 = OfficeSDKManager.getDeviceInfoProvider();
            if (r10 == null) goto L19;
            String r11 = r10.getDeviceId();
        L20:
            r9.e("speak_device_id", r11);
            if (r8 == null) goto L23;
            int r12 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.r.c;
            Pair r13 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.r.a.a(r8);
            String r14 = (String) r13.component1();
            String r15 = (String) r13.component2();
            r9.e("map_user_type", r14);
            r9.e("map_speak_user_id", r15);
        L23:
            r9.e("identify_method", r7.e);
            int r16 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.r.b.a[r7.d.ordinal()];
            if (r16 != 1) goto L26;
            r9.e("speak_user_id", "null" + r7.a);
        L30:
            JSONObject r17 = r9.a();
            String r18 = r17.toString();
            if (r4.b.contains(r18) == true) goto L34;
            lvb.a.e("MmVoicePrintTracker", "reportVoicePrintExposure sessionId: " + r5 + ", params: " + r18);
            r4.b.add(r18);
            r4.a.g(r5, "vc_voiceprint_in_meeting_view", r17);
        L34:
            this.a.v = Long.valueOf(this.b.a);
            MmSubtitleNormalContentViewHolder r19 = this.a;
            ViewTreeObserver.OnPreDrawListener r20 = r19.u;
            if (r20 == null) goto L37;
            ((RecyclerView.ViewHolder) r19).itemView.getViewTreeObserver().removeOnPreDrawListener(r20);
        L37:
            this.a.u = null;
            goto L38
        L26:
            if (r16 == 2) goto L28;
            r9.e("speak_user_id", "null1");
            goto L30
        L28:
            r9.e("speak_user_id", com.ss.android.lark.utils.y.b(r7.a));
            goto L30
        L19:
            r11 = null;
        L38:
            return true;
        L8:
            if (((RecyclerView.ViewHolder) this.a).itemView.getGlobalVisibleRect(r0) == false) goto L14;
            if (r0.height() <= 0) goto L14;
            if (r0.width() <= 0) goto L14;
            r1 = true;
            goto L15
        }
    }

    public final void T3(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r3) {
        if (r3.m == true) goto L5;
    L7:
        Z3(this.c.j, r3.f);
        Y3(this.c.j, this.i);
        this.c.k.setVisibility(8);
        return;
    L5:
        if (r3.n == true) goto L7;
        Z3(this.c.j, r3.e);
        Y3(this.c.j, this.j);
        this.c.k.setVisibility(0);
        Z3(this.c.k, r3.f);
        Y3(this.c.k, this.i);
    }

    public final void U3(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r7) {
        MmDisplaySpeakerEditBackgroundStyle r8 = r7.c();
        int r9 = b.b[r8.ordinal()];
        if (r9 != 1) goto L5;
        Y3(this.c.f, this.k);
        this.c.d.setBackground(null);
        this.c.g.setVisibility(8);
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.b(this.c.h, Integer.valueOf(this.z), null, 14);
        this.c.d.setEnabled(false);
        return;
    L5:
        if (r9 != 2) goto L7;
        Y3(this.c.f, this.k);
        this.c.d.setBackground(null);
        this.c.g.setVisibility(8);
        this.c.d.setEnabled(false);
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.b(this.c.h, Integer.valueOf(this.z), null, 14);
        return;
    L7:
        if (r9 != 3) goto L9;
        this.c.d.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(((RecyclerView.ViewHolder) this).itemView.getContext()).s(((RecyclerView.ViewHolder) this).itemView.getContext()));
        Y3(this.c.f, this.l);
        this.c.g.setVisibility(0);
        this.c.g.setColorFilter(ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), this.h.g()));
        this.c.d.setEnabled(true);
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(this.c.d, MmSubtitleNormalContentViewHolder$bindEditState$1.INSTANCE);
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.b(this.c.h, Integer.valueOf(this.z), null, 14);
        return;
    L9:
        if (r9 != 4) goto L11;
        Y3(this.c.f, this.k);
        this.c.d.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(((RecyclerView.ViewHolder) this).itemView.getContext()).s(((RecyclerView.ViewHolder) this).itemView.getContext()));
        this.c.g.setVisibility(0);
        this.c.g.setColorFilter(ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), this.h.e()));
        this.c.d.setEnabled(true);
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(this.c.d, new MmSubtitleNormalContentViewHolder$bindEditState$2(this));
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.b(this.c.h, Integer.valueOf(this.z), null, 14);
        return;
    L11:
        if (r9 != 5) goto L14;
        Y3(this.c.f, this.k);
        this.c.d.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(((RecyclerView.ViewHolder) this).itemView.getContext()).i(((RecyclerView.ViewHolder) this).itemView.getContext()));
        this.c.g.setVisibility(8);
        this.c.d.setEnabled(true);
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(this.c.d, new MmSubtitleNormalContentViewHolder$bindEditState$3(this));
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.b(this.c.h, Integer.valueOf(this.A), null, 14);
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public final void X3(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r6) {
        Long r0 = this.v;
        long r1 = r6.a;
        if (r0 != null) goto L6;
    L8:
        ViewTreeObserver.OnPreDrawListener r2 = this.u;
        if (r2 != null) goto L11;
    L13:
        d r3 = new d(this, r6);
        this.u = r3;
        ((RecyclerView.ViewHolder) this).itemView.getViewTreeObserver().addOnPreDrawListener(r3);
        return;
    L11:
        if (((RecyclerView.ViewHolder) this).itemView.getViewTreeObserver().isAlive() == false) goto L13;
        ((RecyclerView.ViewHolder) this).itemView.getViewTreeObserver().removeOnPreDrawListener(r2);
        goto L13
    L6:
        if (r0.longValue() != r1) goto L8;
    }

    public static void Y3(TextView r1, int r2) {
        if (r1.getCurrentTextColor() == r2) goto L6;
        r1.setTextColor(r2);
        return;
    }

    public static void Z3(TextView r1, String r2) {
        CharSequence r0 = r1.getText();
        if (r0 == null) goto L5;
        String r3 = r0.toString();
    L7:
        if (Intrinsics.areEqual(r3, r2) == true) goto L10;
        r1.setText(r2);
        return;
    L10:
        return;
    L5:
        r3 = null;
        goto L7
    }

    public final void V3(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r4, MmSubtitleHighlightStyle r5) {
        if (r5 == MmSubtitleHighlightStyle.NONE) goto L9;
        this.c.d.setBackground(null);
        this.c.c.setVisibility(8);
        if (b.a[r5.ordinal()] != 1) goto L7;
        int r6 = this.n;
    L8:
        p r7 = new p(r6, this.q);
        this.x = r7;
        this.c.b.setBackground(r7);
        this.c.b.post(new c(this, r7));
        return;
    L7:
        r6 = this.m;
        goto L8
    L9:
        this.c.c.setVisibility(8);
        if (this.x == null) goto L12;
        this.c.b.setBackground(null);
    L12:
        this.x = null;
        U3(r4);
    }

    public final void W3(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r12, boolean r13) {
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.c r3 = r12.b();
        String r0 = r3.a;
        if (Intrinsics.areEqual(r0, this.t) == true) goto L8;
        Job r1 = this.s;
        if (r1 == null) goto L7;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L7:
        this.s = null;
        this.t = r0;
    L17:
        if (r12.g.d.isLarkUser() == false) goto L19;
        this.s = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.e), null, null, new MmSubtitleNormalContentViewHolder$bindSpeakerInfo$1(this, r12, r3, true, r13, null), 3, null);
        return;
    L19:
        a4(r3, true, r13);
        return;
    L8:
        Job r2 = this.s;
        if (r2 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == false) goto L17;
        return;
    L11:
        if (r2.isActive() != true) goto L13;
        r4 = true;
        goto L14
    }

    public final void a4(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.c r2, boolean r3, boolean r4) {
        if (r4 == false) goto L4;
        Z3(this.c.f, r2.a(MmSubtitleNormalContentViewHolder$bindUserName$1.INSTANCE));
    L4:
        if (r3 == false) goto L7;
        this.c.e.b(r2.f, UIHelper.dp2px(18.0f));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmSubtitleNormalContentViewHolder(String r3, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r4, mwb.j r5, String r6, LifecycleOwner r7, Function1<? super com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h, Unit> r8, Function3<? super com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h, ? super Integer, ? super View, Boolean> r9) {
        Intrinsics.checkNotNullParameter(r3, "recordingId");
        Intrinsics.checkNotNullParameter(r4, "uccApi");
        Intrinsics.checkNotNullParameter(r5, "binding");
        Intrinsics.checkNotNullParameter(r6, "meetingId");
        Intrinsics.checkNotNullParameter(r7, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r8, "onEditSpeakerClick");
        Intrinsics.checkNotNullParameter(r9, "onSubtitleLongClick");
        super(r5.a);
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        com.ss.android.lark.officesdk.minutes.ui.style.contract.d r10 = com.ss.android.lark.officesdk.minutes.ui.style.a.a(((RecyclerView.ViewHolder) this).itemView.getContext());
        this.h = r10;
        this.i = ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), r10.r());
        this.j = ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), r10.p());
        this.k = ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), r10.s());
        this.l = ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), r10.i());
        this.m = ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), r10.j());
        this.n = ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), 2131108731);
        this.o = UIUtils.dp2px(((RecyclerView.ViewHolder) this).itemView.getContext(), 8.0f);
        this.p = UIUtils.dp2px(((RecyclerView.ViewHolder) this).itemView.getContext(), 12.0f);
        this.q = UIUtils.dp2px(((RecyclerView.ViewHolder) this).itemView.getContext(), 8.0f);
        this.r = com.ss.android.lark.officesdk.minutes.ui.style.b.a(r5.a.getContext()).f(r5.a.getContext());
        MmUserInfoHelper r11 = r4.O();
        this.y = r11;
        MmSubtitleSpeakerAvatarView r12 = r5.e;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r11, "helper");
        Intrinsics.checkNotNullParameter(r6, "meetingId");
        r12.e = r11;
        r5.b.setOnLongClickListener(new a(this));
        this.z = UIHelper.dp2px(12.0f);
        this.A = UIHelper.dp2px(6.0f);
    }
}

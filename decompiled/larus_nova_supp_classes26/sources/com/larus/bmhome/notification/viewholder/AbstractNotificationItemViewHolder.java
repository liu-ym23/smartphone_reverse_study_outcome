package com.larus.bmhome.notification.viewholder;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.resp.Button;
import com.larus.bmhome.chat.resp.CommonNoticeData;
import com.larus.bmhome.chat.resp.Notice;
import com.larus.bmhome.chat.resp.Range;
import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.common_ui.widget.roundlayout.CircleFrameLayout;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.image.loader.b0;
import com.larus.notify.impl.databinding.LarusItemNotificationDefaultBinding;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import or8.b;
import or8.c;
import or8.d;
import or8.e;
import or8.f;
import or8.g;
import or8.h;
import or8.i;
import or8.j;
import or8.k;
import or8.l;
import r27.a;
import v19.b7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\b&\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010/\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J/\u00100\u001a\u00020!2%\u00101\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020!\u0018\u00010\u001dH\u0016JD\u00102\u001a\u00020!2:\u00101\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020!\u0018\u00010#H\u0016J\u0010\u00103\u001a\u00020!2\u0006\u00104\u001a\u00020\u001bH\u0004J\u0010\u00105\u001a\u00020!2\u0006\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020!H\u0003Jp\u00109\u001a\u00020!2f\u0010)\u001ab\u0012\u0015\u0012\u0013\u0018\u00010+¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(,\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020!\u0018\u00010*H\u0016J\b\u0010:\u001a\u00020!H\u0002J\b\u0010;\u001a\u00020!H\u0002J\u0012\u0010<\u001a\u00020!2\b\u0010\u0014\u001a\u0004\u0018\u00010=H\u0002J\u0012\u0010>\u001a\u00020!2\b\u0010\u0014\u001a\u0004\u0018\u00010=H\u0003J\b\u0010?\u001a\u00020!H\u0003J\b\u0010@\u001a\u00020!H\u0002J\b\u0010A\u001a\u00020!H\u0002J\u0010\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020!H\u0002J\n\u0010F\u001a\u0004\u0018\u00010+H&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\u001c\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020!\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000RN\u0010\"\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020!\u0018\u00010#X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(Rn\u0010)\u001ab\u0012\u0015\u0012\u0013\u0018\u00010+¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(,\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020!\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/larus/bmhome/notification/viewholder/AbstractNotificationItemViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "Lcom/larus/bmhome/notification/viewholder/INotificationItemViewHolder;", "viewBinding", "Lcom/larus/notify/impl/databinding/LarusItemNotificationDefaultBinding;", "<init>", "(Lcom/larus/notify/impl/databinding/LarusItemNotificationDefaultBinding;)V", "TAG", "", "clickX", "", "clickY", "screenPos", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "data", "Lcom/larus/bmhome/chat/resp/Notice;", "getData", "()Lcom/larus/bmhome/chat/resp/Notice;", "setData", "(Lcom/larus/bmhome/chat/resp/Notice;)V", "readStatus", "Lcom/larus/bmhome/notification/viewholder/AbstractNotificationItemViewHolder$Companion$ReadStatus;", "unreadChangeListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "notice", "", "itemClickListener", "Lkotlin/Function2;", "clickFrom", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "itemLongClickListener", "Lkotlin/Function4;", "Landroid/view/View;", "anchor", "x", "y", "bindViewHolder", "setOnUnreadChangeListener", "listener", "setOnItemClickListener", "changeNotificationUnreadStatus", "newReadStatus", "changeUnreadStyle", "hasRead", "", "setupRootView", "setOnItemLongClickListener", "setupUnreadDot", "setupLeftButton", "setupAvatar", "Lcom/larus/bmhome/chat/resp/Button;", "setupLeftButtonClickListener", "setupContent", "setupAccessibilityContent", "setupBodyText", "formatCreateTime", "createTime", "", "setupRightButton", "getRightButton", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbstractNotificationItemViewHolder extends ViewBindingHolder implements l {
    public static final /* synthetic */ int k = 0;
    public final LarusItemNotificationDefaultBinding a;
    public float b;
    public float c;
    public final int[] d;
    public final Lazy e;
    public Notice f;
    public Companion.ReadStatus g;
    public Function1<? super Notice, Unit> h;
    public Function2<? super Notice, ? super String, Unit> i;
    public Function4<? super View, ? super Notice, ? super Float, ? super Float, Unit> j;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/notification/viewholder/AbstractNotificationItemViewHolder$Companion$ReadStatus;", "", "<init>", "(Ljava/lang/String;I)V", "READ", "UNREAD", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum ReadStatus extends Enum<ReadStatus> {
            public static final ReadStatus READ = null;
            public static final ReadStatus UNREAD = null;
            public static final /* synthetic */ ReadStatus[] a = null;
            public static final /* synthetic */ EnumEntries b = null;

            public static EnumEntries<ReadStatus> getEntries() {
                return b;
            }

            static {
                ReadStatus r0 = new ReadStatus("READ", 0);
                READ = r0;
                ReadStatus r1 = new ReadStatus("UNREAD", 1);
                UNREAD = r1;
                ReadStatus[] r3 = {r0, r1};
                a = r3;
                b = EnumEntriesKt.enumEntries(r3);
            }

            public static ReadStatus[] values() {
                return (ReadStatus[]) a.clone();
            }

            public static ReadStatus valueOf(String r1) {
                return (ReadStatus) a.a(ReadStatus.class, r1);
            }

            public ReadStatus(String r1, int r2) {
                super(r1, r2);
            }
        }
    }

    static {
    }

    public abstract View V3();

    public final Context getContext() {
        return (Context) this.e.getValue();
    }

    public AbstractNotificationItemViewHolder(LarusItemNotificationDefaultBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "viewBinding");
        super(r2);
        this.a = r2;
        this.d = new int[2];
        this.e = LazyKt.lazy(new or8.a(this));
        this.g = Companion.ReadStatus.READ;
    }

    @Override // or8.l
    public final void K1(Function2<? super Notice, ? super String, Unit> r1) {
        this.i = r1;
    }

    @Override // or8.l
    public final void T0(Function1<? super Notice, Unit> r1) {
        this.h = r1;
    }

    public final void T3(Companion.ReadStatus r3) {
        Intrinsics.checkNotNullParameter(r3, "newReadStatus");
        if (this.g != Companion.ReadStatus.UNREAD) goto L10;
        if (r3 != Companion.ReadStatus.READ) goto L10;
        Function1<? super Notice, Unit> r0 = this.h;
        if (r0 == null) goto L10;
        r0.invoke(this.f);
    L10:
        if (this.g == r3) goto L13;
        this.g = r3;
    L13:
        if (this.g != Companion.ReadStatus.READ) goto L15;
        boolean r4 = true;
    L16:
        Notice r1 = this.f;
        if (r1 == null) goto L19;
        r1.setHasRead(r4);
    L19:
        U3(r4);
        return;
    L15:
        r4 = false;
        goto L16
    }

    public final void U3(boolean r6) {
        if (z2.a.P3() != 1) goto L9;
        View r0 = this.a.h;
        if (r6 == false) goto L7;
        int r7 = 4;
    L8:
        r0.setVisibility(r7);
        e1.u(this.a.a, 0.0f, 2131102529, 2131103188);
        return;
    L7:
        r7 = 0;
        goto L8
    L9:
        this.a.h.setVisibility(8);
        if (r6 == false) goto L12;
        e1.u(this.a.a, 0.0f, 2131102529, 2131103188);
        return;
    L12:
        e1.u(this.a.a, 0.0f, 2131103215, 2131103188);
    }

    @Override // or8.l
    public final void a3(Function4<? super View, ? super Notice, ? super Float, ? super Float, Unit> r1) {
        this.j = r1;
    }

    @Override // or8.l
    public final void g2(Notice r20) {
        Intrinsics.checkNotNullParameter(r20, "data");
        this.f = r20;
        e1.d(this.a.a, new i(this));
        this.a.a.setOnLongClickListener(new j(this));
        this.a.a.setOnTouchListener(new k(this));
        Notice r1 = this.f;
        long r2 = 0;
        if (r1 != null) goto L5;
    L17:
        Companion.ReadStatus r3 = Companion.ReadStatus.READ;
    L18:
        this.g = r3;
        if (r3 != Companion.ReadStatus.READ) goto L21;
        boolean r4 = true;
    L22:
        U3(r4);
        Notice r5 = this.f;
        String r6 = null;
        if (r5 == null) goto L27;
        CommonNoticeData r7 = r5.getCommonNoticeData();
        if (r7 == null) goto L27;
        Button r8 = r7.getLeftButton();
    L28:
        if (r8 == null) goto L30;
        String r9 = r8.getContent();
    L31:
        if (r9 != null) goto L33;
    L36:
        boolean r10 = true;
    L37:
        if (r10 == false) goto L39;
        Uri r11 = new Uri.Builder().scheme("res").path(String.valueOf(2131240119)).build();
    L40:
        Uri r12 = r11;
        CircleFrameLayout r13 = this.a.e;
        if (r8 == null) goto L43;
        boolean r14 = Intrinsics.areEqual(r8.getDisableClip(), Boolean.FALSE);
    L44:
        r13.a(r14);
        ImageLoaderKt.x(this.a.b, r12, null, null, new b(), 6);
        Notice r15 = this.f;
        if (r15 == null) goto L49;
        CommonNoticeData r16 = r15.getCommonNoticeData();
        if (r16 == null) goto L49;
        r16.getLeftButton();
    L49:
        e1.d(this.a.e, new f(this));
        this.a.e.setOnLongClickListener(new g(this));
        this.a.e.setOnTouchListener(new h(this));
        TextView r17 = this.a.g;
        Notice r18 = this.f;
        String r19 = "";
        if (r18 == null) goto L56;
        CommonNoticeData r21 = r18.getCommonNoticeData();
        if (r21 == null) goto L56;
        String r22 = r21.getTitle();
        if (r22 == null) goto L56;
    L57:
        r17.setText(r22);
        e1.d(r17, new c(this));
        r17.setOnLongClickListener(new d(this));
        r17.setOnTouchListener(new e(this));
        TextView r23 = this.a.c;
        Notice r24 = this.f;
        if (r24 == null) goto L62;
        CommonNoticeData r25 = r24.getCommonNoticeData();
        if (r25 == null) goto L62;
        String r26 = r25.getBody();
    L63:
        if (r26 != null) goto L65;
        r26 = "";
    L65:
        SpannableString r27 = new SpannableString(r26);
        Notice r28 = this.f;
        if (r28 == null) goto L72;
        CommonNoticeData r29 = r28.getCommonNoticeData();
        if (r29 == null) goto L72;
        String r30 = r29.getBody();
        if (r30 == null) goto L72;
        int r31 = r30.length();
    L73:
        Notice r110 = this.f;
        if (r110 == null) goto L94;
        CommonNoticeData r111 = r110.getCommonNoticeData();
        if (r111 == null) goto L94;
        List r112 = r111.getBoldBodyRangeList();
        if (r112 == null) goto L94;
        Iterator r113 = r112.iterator();
    L81:
        if (r113.hasNext() == false) goto L94;
        Range r114 = (Range) r113.next();
        if (r114 == null) goto L85;
        Integer r115 = r114.getStart();
    L86:
        if (r114 == null) goto L88;
        Integer r116 = r114.getLength();
    L89:
        if (r115 == null) goto L81;
        if (r116 == null) goto L81;
        Integer r117 = Integer.valueOf(RangesKt.coerceIn(r115.intValue(), 0, r31));
        int r118 = RangesKt.coerceIn(r117.intValue() + r116.intValue(), 0, r31);
        if (r117.intValue() >= r118) goto L81;
        r27.setSpan(new StyleSpan(1), r117.intValue(), r118, 33);
        goto L81
    L88:
        r116 = null;
        goto L89
    L85:
        r115 = null;
    L94:
        r23.setText(r27);
        if (StringsKt.isBlank(r23.getText()) == false) goto L97;
        int r32 = 8;
    L98:
        r23.setVisibility(r32);
        TextView r33 = this.a.d;
        Notice r34 = this.f;
        if (r34 == null) goto L101;
        r2 = r34.getCreateTime();
    L101:
        r33.setText(b7.a(r2));
        CharSequence r35 = this.a.g.getText();
        if (r35 == null) goto L106;
        String r36 = r35.toString();
        if (r36 == null) goto L106;
        String r37 = StringsKt.trim(r36).toString();
    L107:
        if (r37 != null) goto L109;
        r37 = "";
    L109:
        CharSequence r38 = this.a.c.getText();
        if (r38 == null) goto L114;
        String r39 = r38.toString();
        if (r39 == null) goto L114;
        String r40 = StringsKt.trim(r39).toString();
    L115:
        if (r40 != null) goto L117;
        r40 = "";
    L117:
        CharSequence r41 = this.a.d.getText();
        if (r41 == null) goto L122;
        String r42 = r41.toString();
        if (r42 == null) goto L122;
        String r43 = StringsKt.trim(r42).toString();
    L123:
        if (r43 == null) goto L126;
        r19 = r43;
    L126:
        List r44 = CollectionsKt.listOf(new String[]{r37, r40, r19});
        ArrayList r119 = new ArrayList();
        Iterator r45 = r44.iterator();
    L128:
        if (r45.hasNext() == false) goto L132;
        Object r46 = r45.next();
        if ((!StringsKt.isBlank((String) r46)) == false) goto L128;
        r119.add(r46);
        goto L128
    L132:
        ConstraintLayout r47 = this.a.a;
        String r48 = CollectionsKt.joinToString$default(r119, "\n", null, null, 0, null, null, 62, null);
        if ((!StringsKt.isBlank(r48)) == false) goto L135;
        r6 = r48;
    L135:
        r47.setContentDescription(r6);
        View r49 = V3();
        if (r49 != null) goto L138;
        this.a.f.setVisibility(8);
        return;
    L138:
        this.a.f.removeAllViews();
        this.a.f.addView(r49);
        return;
    L122:
        r43 = null;
    L114:
        r40 = null;
    L106:
        r37 = null;
        goto L107
    L97:
        r32 = 0;
    L72:
        r31 = 0;
    L62:
        r26 = null;
    L56:
        r22 = "";
        goto L57
    L43:
        r14 = false;
        goto L44
    L39:
        r11 = b0.a(r9, "notice.left_avatar", false, false, 6);
        goto L40
    L33:
        if (r9.length() == 0) goto L36;
        r10 = false;
        goto L37
    L30:
        r9 = null;
    L27:
        r8 = null;
        goto L28
    L21:
        r4 = false;
        goto L22
    L5:
        if (r1.getHasRead() != true) goto L7;
        boolean r50 = true;
    L8:
        if (r50 == true) goto L17;
        Notice r51 = this.f;
        if (r51 == null) goto L12;
        long r52 = r51.getNoticeId();
    L14:
        if (r52 <= 0) goto L17;
        r3 = Companion.ReadStatus.UNREAD;
        goto L18
    L12:
        r52 = 0;
        goto L14
    L7:
        r50 = false;
        goto L8
    }
}

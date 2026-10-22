package com.obric.oui.picker.reels.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.plugin.R;
import com.obric.oui.calendar.ODatePickerView;
import com.obric.oui.common.util.h;
import com.obric.oui.picker.reels.views.OReelPickerMulti;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker;", "Lcom/obric/oui/picker/OPicker;", "Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$PickedData;", "()V", "mBuilder", "Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$Builder;", "asView", "Landroid/view/View;", "getPicked", "Builder", "PickedData", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C0763a f14287a;

    /* JADX INFO: renamed from: com.obric.oui.picker.reels.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004JA\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u000e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010$\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010%JW\u0010&\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000e2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010$\u001a\u00020\u0011¢\u0006\u0002\u0010+JA\u0010,\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u000e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010$\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010%JU\u0010-\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010$\u001a\u00020\u0011H\u0007¢\u0006\u0002\u00101JK\u00102\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u00100\u001a\u00020/2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010$\u001a\u00020\u0011H\u0007¢\u0006\u0002\u00103JA\u00104\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u000e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010$\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010%JA\u00105\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u000e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u0001062\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010$\u001a\u00020\u0011H\u0007¢\u0006\u0002\u00107Je\u00108\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u000e2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)2\b\b\u0002\u00109\u001a\u00020\u000e2\b\b\u0002\u0010:\u001a\u00020\u00112\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0002\u0010<JK\u0010=\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u00100\u001a\u00020/2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010$\u001a\u00020\u0011H\u0007¢\u0006\u0002\u00103JA\u0010>\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u000e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010$\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010%JU\u0010?\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010@\u001a\u00020\u000e2\b\b\u0002\u0010A\u001a\u00020\u000e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010$\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010BJ\"\u0010C\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020\u000eH\u0016J\b\u0010G\u001a\u00020HH\u0002J\u000e\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u000eJ\u000e\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0011J\u0016\u0010M\u001a\u00020H2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0016J\u000e\u0010O\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u000eJ\u000e\u0010P\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$Builder;", "Lcom/obric/oui/picker/reels/pickers/OReelPickerBuilder;", "Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker;", "Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$PickedData;", "()V", "mBuilt", "Lcom/obric/oui/picker/reels/OReelPicker;", "getMBuilt$OUI_standardRelease", "()Lcom/obric/oui/picker/reels/OReelPicker;", "setMBuilt$OUI_standardRelease", "(Lcom/obric/oui/picker/reels/OReelPicker;)V", "mChangedListener", "Ljava/util/function/Consumer;", "mHeight", "", "Ljava/lang/Integer;", "mHeightPercentOfParent", "", "Ljava/lang/Float;", "mReels", "", "Lcom/obric/oui/picker/reels/OReelPicker$Reel;", "mSelections", "", "getMSelections$OUI_standardRelease", "()Ljava/util/Map;", "mWidth", "mWidthPercentOfParent", "rcListener", "Lcom/obric/oui/picker/reels/OReelPicker$ReelChangedListener;", "addAmPm", "context", "Landroid/content/Context;", OaidModel.KEY_ID, BuildConfig.FLAVOR, "width", "weight", "(Landroid/content/Context;ILjava/lang/Integer;Ljava/lang/Integer;F)Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$Builder;", "addCustom", "entries", "", "", LocationMonitorConst.TAG, "(Landroid/content/Context;ILjava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;F)Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$Builder;", "addDay", "addHour", "is24Hour", "", "showTag", "(Landroid/content/Context;IZZLjava/lang/Integer;Ljava/lang/Integer;F)Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$Builder;", "addMinute", "(Landroid/content/Context;IZLjava/lang/Integer;Ljava/lang/Integer;F)Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$Builder;", "addMonth", "addOneYearDateWithWeek", "Ljava/time/LocalDate;", "(Landroid/content/Context;ILjava/time/LocalDate;Ljava/lang/Integer;F)Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$Builder;", "addReel", "selectedIndex", "widthWeight", "tagGap", "(ILjava/util/List;Ljava/lang/String;IFLjava/lang/Integer;Ljava/lang/Integer;Landroid/content/Context;)Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$Builder;", "addSecond", "addTimeMode", "addYear", "from", TypedValues.TransitionType.S_TO, "(Landroid/content/Context;IIILjava/lang/Integer;Ljava/lang/Integer;F)Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$Builder;", "build", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "notifyChange", "", "setHeight", "height", "setHeightPercentOfParent", "percent", "setOnChangedListener", "listener", "setWidth", "setWidthPercentOfParent", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0763a implements com.obric.oui.picker.reels.a.b<a, b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Consumer<b> f14288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f14289b;
        private Integer c;
        private Float d;
        private Float e;
        private final List<com.obric.oui.picker.reels.a.b> f;
        private final Map<Integer, Integer> g;
        private com.obric.oui.picker.reels.a h;
        private final com.obric.oui.picker.reels.a.c i;

        public C0763a() {
            this.f = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            this.g = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            this.i = new $$Lambda$a$a$HhLBYLh7acWLi4pKGodhKXNQ1I(this);
        }

        public static /* synthetic */ C0763a a(C0763a r9, int r10, List r11, String r12, int r13, float r14, Integer r15, Integer r16, Context r17, int r18, Object r19) {
            List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.memorydata.plugin");
            if ((r18 & 4) == 0) goto L5;
            String r3 = null;
        L7:
            if ((r18 & 8) == 0) goto L9;
            int r5 = 0;
        L11:
            if ((r18 & 16) == 0) goto L13;
            float r6 = 1.0f;
        L15:
            if ((r18 & 32) == 0) goto L17;
            Integer r7 = null;
        L19:
            if ((r18 & 64) == 0) goto L21;
            Integer r8 = null;
        L23:
            if ((r18 & 128) == 0) goto L26;
            r2 = null;
        L26:
            return r9.a(r10, r1, r3, r5, r6, r7, r8, r2);
        L21:
            r8 = r16;
            goto L23
        L17:
            r7 = r15;
            goto L19
        L13:
            r6 = r14;
            goto L15
        L9:
            r5 = r13;
            goto L11
        L5:
            r3 = r12;
            goto L7
        }

        public static /* synthetic */ C0763a a(C0763a r5, Context r6, int r7, int r8, int r9, Integer r10, Integer r11, float r12, int r13, Object r14) {
            Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            if ((r13 & 2) == 0) goto L5;
            r7 = 1001;
        L5:
            int r16 = r7;
            if ((r13 & 4) == 0) goto L8;
            r8 = ODatePickerView.YEAR_FROM;
        L8:
            int r0 = r8;
            if ((r13 & 8) == 0) goto L11;
            r9 = ODatePickerView.YEAR_TO;
        L11:
            int r1 = r9;
            if ((r13 & 16) == 0) goto L14;
            Integer r2 = null;
        L16:
            if ((r13 & 32) == 0) goto L18;
            Integer r3 = null;
        L20:
            if ((r13 & 64) == 0) goto L23;
            r12 = 1.0f;
        L23:
            return r5.a(r15, r16, r0, r1, r2, r3, r12);
        L18:
            r3 = r11;
            goto L20
        L14:
            r2 = r10;
            goto L16
        }

        public static /* synthetic */ C0763a a(C0763a r3, Context r4, int r5, Integer r6, Integer r7, float r8, int r9, Object r10) {
            Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            if ((r9 & 2) == 0) goto L5;
            r5 = 1002;
        L5:
            int r12 = r5;
            Integer r0 = null;
            if ((r9 & 4) == 0) goto L8;
            Integer r1 = null;
        L10:
            if ((r9 & 8) != 0) goto L14;
            r0 = r7;
        L14:
            if ((r9 & 16) == 0) goto L17;
            r8 = 1.0f;
        L17:
            return r3.a(r11, r12, r1, r0, r8);
        L8:
            r1 = r6;
            goto L10
        }

        private static final void a(C0763a r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            r1.g.put(Integer.valueOf(r2), Integer.valueOf(r3));
            r1.b();
        }

        private final void b() {
            Consumer<b> r0 = this.f14288a;
            if (r0 == null) goto L7;
            r0.accept(new b(MapsKt.toMap(this.g)));
            return;
        }

        /* JADX INFO: renamed from: lambda$HhLBYL-h7acWLi4pKGodhKXNQ1I, reason: not valid java name */
        public static /* synthetic */ void m1331lambda$HhLBYLh7acWLi4pKGodhKXNQ1I(C0763a r0, int r1, int r2) {
            a(r0, r1, r2);
        }

        public final C0763a a(float r1) {
            this.d = Float.valueOf(r1);
            return this;
        }

        public final C0763a a(int r1) {
            this.c = Integer.valueOf(r1);
            this.e = null;
            return this;
        }

        public final C0763a a(int r16, List<String> r17, String r18, int r19, float r20, Integer r21, Integer r22, Context r23) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entries");
            if (r2 == null) goto L13;
            if (r21 == null) goto L6;
            int r3 = r21.intValue();
        L12:
            Integer r10 = Integer.valueOf(r3);
        L14:
            this.f.add(new com.obric.oui.picker.reels.a.b(r16, r6, (CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin"), r20, r21, r10, r22, r19, this.i));
            this.g.put(Integer.valueOf(r16), Integer.valueOf(r19));
            return this;
        L6:
            if (r18 != null) goto L10;
            if (r22 != null) goto L10;
            int r4 = 72;
        L11:
            r3 = h.a(r2, r4);
        L10:
            r4 = 92;
            goto L11
        L13:
            r10 = r21;
            goto L14
        }

        public final C0763a a(Context r23, int r24, int r25, int r26, Integer r27, Integer r28, float r29) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "context");
            c r4 = c.f14291a;
            String r7 = r1.getString(ZeusTransformUtils.mapRes(R.string.oui_reel_picker_year_tag, TypedValues.Custom.S_STRING, "oui_reel_picker_year_tag"));
            Intrinsics.checkNotNullExpressionValue(r7, "context.getString(R.stri…oui_reel_picker_year_tag)");
            List r13 = c.a(r4, r25, r26, r7, 0, 8, null);
            if (r27 != null) goto L5;
            int r15 = 0;
        L7:
            return a(this, r24, r13, null, r15, r29, r28, null, null, 192, null);
        L5:
            r15 = Math.max(0, Math.min(((Number) ZeusTransformUtils.preCheckCast(r27, Number.class, "com.obric.memorydata.plugin")).intValue() - r25, r13.size() - 1));
            goto L7
        }

        public final C0763a a(Context r18, int r19, Integer r20, Integer r21, float r22) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "context");
            List<String> r8 = c.f14291a.a(r1, 1, 12);
            if (r20 != null) goto L5;
            int r10 = 0;
        L7:
            return a(this, r19, r8, null, r10, r22, r21, null, null, 192, null);
        L5:
            r10 = Math.max(0, Math.min(((Number) ZeusTransformUtils.preCheckCast(r20, Number.class, "com.obric.memorydata.plugin")).intValue() - 1, 11));
            goto L7
        }

        public a a(Context r6, AttributeSet r7, int r8) {
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r9, "context");
            OReelPickerMulti.a r0 = new OReelPickerMulti.a();
            Integer r2 = this.f14289b;
            if (r2 == null) goto L6;
            r0.a(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).intValue());
        L6:
            Integer r3 = this.c;
            if (r3 == null) goto L10;
            r0.b(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue());
        L10:
            Float r4 = this.d;
            if (r4 == null) goto L14;
            r0.a(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).floatValue());
        L14:
            Float r5 = this.e;
            if (r5 == null) goto L18;
            r0.b(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).floatValue());
        L18:
            Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L20:
            if (r11.hasNext() == false) goto L22;
            r0.a((com.obric.oui.picker.reels.a.b) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.oui.picker.reels.a.b.class, "com.obric.memorydata.plugin"));
            goto L20
        L22:
            this.h = r0.a(r9, r10, r8);
            a r12 = new a();
            a.a(r12, this);
            return r12;
        }

        public final com.obric.oui.picker.reels.a a() {
            return this.h;
        }

        public void a(Consumer<b> r3) {
            Consumer<b> r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "listener");
            this.f14288a = r4;
        }

        @Override // com.obric.oui.picker.reels.a.b
        public /* synthetic */ a b(Context r3, AttributeSet r4, int r5) {
            return a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0015\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001f\u0010\t\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0004HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$PickedData;", "", "selections", "", "", "(Ljava/util/Map;)V", "getSelections", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<Integer, Integer> f14290a;

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public b(Map<Integer, Integer> r3) {
            Map<Integer, Integer> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "selections");
            this.f14290a = r4;
        }

        public /* synthetic */ b(Map r2, int r3, DefaultConstructorMarker r4) {
            Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
            if ((r3 & 1) == 0) goto L5;
            r5 = MapsKt.emptyMap();
        L5:
            this(r5);
        }

        public final Map<Integer, Integer> a() {
            return this.f14290a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f14290a, r6.f14290a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f14290a.hashCode();
        }

        public String toString() {
            return "PickedData(selections=" + this.f14290a + ')';
        }
    }

    public a() {
    }

    public static final /* synthetic */ void a(a r0, C0763a r1) {
        r0.f14287a = r1;
    }

    public View a() {
        C0763a r1 = this.f14287a;
        if (r1 == null) goto L10;
        com.obric.oui.picker.reels.a r2 = r1.a();
        if (r2 != null) goto L9;
        return null;
    L9:
        return r2.asView();
    L10:
        return null;
    }
}

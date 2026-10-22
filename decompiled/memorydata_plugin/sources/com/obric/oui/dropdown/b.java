package com.obric.oui.dropdown;

import android.app.Activity;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\bf\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00030\u000bH&¨\u0006\r"}, d2 = {"Lcom/obric/oui/dropdown/ODropdown;", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "caller", "Lcom/obric/oui/dropdown/ODropdownTrigger;", "activity", "Landroid/app/Activity;", "onDismiss", "Lkotlin/Function0;", "onTextChanged", "Lkotlin/Function1;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface b {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ void a(b r2, final ODropdownTrigger r3, Activity r4, Function0 r5, Function1 r6, int r7, Object r8) {
            b r9 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
            Activity r10 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
            Function0<Unit> r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
            Function1<? super CharSequence, Unit> r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L10;
            if ((r7 & 4) == 0) goto L7;
            r11 = (Function0) ZeusTransformUtils.preCheckCast(new ODropdown$start$1(r3), Function0.class, "com.obric.memorydata.plugin");
        L7:
            r9.a(r3, r10, r11, r12);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
        }
    }

    void a(ODropdownTrigger r1, Activity r2, Function0<Unit> r3, Function1<? super CharSequence, Unit> r4);
}

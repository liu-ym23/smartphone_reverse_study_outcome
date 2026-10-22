package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0080\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022d\b\u0006\u0010\u0003\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u00042d\b\u0006\u0010\u000e\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\r0\u00042%\b\u0006\u0010\u0010\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\r0\u0011H\u0086\b\u001a4\u0010\u0013\u001a\u00020\u0001*\u00020\u00022%\b\u0004\u0010\u0014\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\r0\u0011H\u0086\b\u001as\u0010\u0015\u001a\u00020\u0001*\u00020\u00022d\b\u0004\u0010\u0014\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0004H\u0086\b\u001as\u0010\u0016\u001a\u00020\u0001*\u00020\u00022d\b\u0004\u0010\u0014\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\r0\u0004H\u0086\b¨\u0006\u0017"}, d2 = {"addTextChangedListener", "Landroid/text/TextWatcher;", "Landroid/widget/TextView;", "beforeTextChanged", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, CommonConsts.COUNT_TYPE, "after", "", "onTextChanged", "before", "afterTextChanged", "Lkotlin/Function1;", "Landroid/text/Editable;", "doAfterTextChanged", "action", "doBeforeTextChanged", "doOnTextChanged", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextViewKt {
    public static final TextWatcher addTextChangedListener(TextView r2, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r3, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r4, Function1<? super Editable, Unit> r5) {
        Function4 r6 = (Function4) ZeusTransformUtils.wrapperContextForParams(r3, Function4.class, "com.obric.memorydata.plugin");
        Function4 r7 = (Function4) ZeusTransformUtils.wrapperContextForParams(r4, Function4.class, "com.obric.memorydata.plugin");
        TextViewKt$addTextChangedListener$textWatcher$1 r0 = new TextViewKt$addTextChangedListener$textWatcher$1((Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin"), r6, r7);
        r2.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r0, TextWatcher.class, "com.obric.memorydata.plugin"));
        return (TextWatcher) ZeusTransformUtils.preCheckCast(r0, TextWatcher.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ TextWatcher addTextChangedListener$default(TextView r1, Function4 r2, Function4 r3, Function1 r4, int r5, Object r6) {
        Function4 r7 = (Function4) ZeusTransformUtils.wrapperContextForParams(r2, Function4.class, "com.obric.memorydata.plugin");
        Function4 r8 = (Function4) ZeusTransformUtils.wrapperContextForParams(r3, Function4.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = (Function4) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, Function4.class, "com.obric.memorydata.plugin");
    L6:
        if ((r5 & 2) == 0) goto L9;
        r8 = (Function4) ZeusTransformUtils.preCheckCast(AnonymousClass2.INSTANCE, Function4.class, "com.obric.memorydata.plugin");
    L9:
        if ((r5 & 4) == 0) goto L11;
        r9 = (Function1) ZeusTransformUtils.preCheckCast(AnonymousClass3.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L11:
        TextViewKt$addTextChangedListener$textWatcher$1 r10 = new TextViewKt$addTextChangedListener$textWatcher$1(r9, r7, r8);
        r1.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r10, TextWatcher.class, "com.obric.memorydata.plugin"));
        return (TextWatcher) ZeusTransformUtils.preCheckCast(r10, TextWatcher.class, "com.obric.memorydata.plugin");
    }

    public static final TextWatcher doAfterTextChanged(TextView r2, Function1<? super Editable, Unit> r3) {
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        TextWatcher r0 = new TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1(r4);
        r2.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r0, TextWatcher.class, "com.obric.memorydata.plugin"));
        return (TextWatcher) ZeusTransformUtils.preCheckCast(r0, TextWatcher.class, "com.obric.memorydata.plugin");
    }

    public static final TextWatcher doBeforeTextChanged(TextView r2, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r3) {
        final Function4 r4 = (Function4) ZeusTransformUtils.wrapperContextForParams(r3, Function4.class, "com.obric.memorydata.plugin");
        TextWatcher r0 = new TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1(r4);
        r2.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r0, TextWatcher.class, "com.obric.memorydata.plugin"));
        return (TextWatcher) ZeusTransformUtils.preCheckCast(r0, TextWatcher.class, "com.obric.memorydata.plugin");
    }

    public static final TextWatcher doOnTextChanged(TextView r2, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r3) {
        final Function4 r4 = (Function4) ZeusTransformUtils.wrapperContextForParams(r3, Function4.class, "com.obric.memorydata.plugin");
        TextWatcher r0 = new TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1(r4);
        r2.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r0, TextWatcher.class, "com.obric.memorydata.plugin"));
        return (TextWatcher) ZeusTransformUtils.preCheckCast(r0, TextWatcher.class, "com.obric.memorydata.plugin");
    }
}

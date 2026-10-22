package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 176)
public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {
    final /* synthetic */ Function1<Editable, Unit> $afterTextChanged;
    final /* synthetic */ Function4<CharSequence, Integer, Integer, Integer, Unit> $beforeTextChanged;
    final /* synthetic */ Function4<CharSequence, Integer, Integer, Integer, Unit> $onTextChanged;

    public TextViewKt$addTextChangedListener$textWatcher$1(Function1<? super Editable, Unit> r3, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r4, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r5) {
        Function1<Editable, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function4<CharSequence, Integer, Integer, Integer, Unit> r7 = (Function4) ZeusTransformUtils.wrapperContextForParams(r4, Function4.class, "com.obric.memorydata.plugin");
        Function4<CharSequence, Integer, Integer, Integer, Unit> r8 = (Function4) ZeusTransformUtils.wrapperContextForParams(r5, Function4.class, "com.obric.memorydata.plugin");
        this.$afterTextChanged = r6;
        this.$beforeTextChanged = r7;
        this.$onTextChanged = r8;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r3) {
        Editable r4 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.memorydata.plugin");
        this.$afterTextChanged.invoke(r4);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r3, int r4, int r5, int r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.$beforeTextChanged.invoke(r7, Integer.valueOf(r4), Integer.valueOf(r5), Integer.valueOf(r6));
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r3, int r4, int r5, int r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.$onTextChanged.invoke(r7, Integer.valueOf(r4), Integer.valueOf(r5), Integer.valueOf(r6));
    }
}

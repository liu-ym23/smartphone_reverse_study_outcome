package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n*L\n1#1,97:1\n*E\n"})
public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {
    final /* synthetic */ Function1<Editable, Unit> $afterTextChanged;
    final /* synthetic */ Function4<CharSequence, Integer, Integer, Integer, Unit> $beforeTextChanged;
    final /* synthetic */ Function4<CharSequence, Integer, Integer, Integer, Unit> $onTextChanged;

    /* JADX WARN: Multi-variable type inference failed */
    public TextViewKt$addTextChangedListener$textWatcher$1(Function1<? super Editable, Unit> r10, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r11, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r12) {
        this.$afterTextChanged = r10;
        this.$beforeTextChanged = r11;
        this.$onTextChanged = r12;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r10) {
        this.$afterTextChanged.invoke(r10);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
        this.$beforeTextChanged.invoke(r10, Integer.valueOf(r11), Integer.valueOf(r12), Integer.valueOf(r13));
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
        this.$onTextChanged.invoke(r10, Integer.valueOf(r11), Integer.valueOf(r12), Integer.valueOf(r13));
    }
}

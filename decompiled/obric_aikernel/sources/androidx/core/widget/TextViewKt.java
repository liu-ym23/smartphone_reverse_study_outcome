package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,97:1\n65#1:98\n77#1,4:99\n93#1,3:103\n65#1,16:106\n93#1,3:122\n65#1,16:125\n93#1,3:141\n*S KotlinDebug\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n35#1:98\n35#1:99,4\n35#1:103,3\n49#1:106,16\n49#1:122,3\n58#1:125,16\n58#1:141,3\n*E\n"})
public final class TextViewKt {
    public static final TextWatcher addTextChangedListener(TextView r10, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r11, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r12, Function1<? super Editable, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "beforeTextChanged");
        Intrinsics.checkNotNullParameter(r12, "onTextChanged");
        Intrinsics.checkNotNullParameter(r13, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 r14 = new TextViewKt$addTextChangedListener$textWatcher$1(r13, r11, r12);
        r10.addTextChangedListener(r14);
        return r14;
    }

    public static /* synthetic */ TextWatcher addTextChangedListener$default(TextView r10, Function4 r11, Function4 r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = AnonymousClass1.INSTANCE;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = AnonymousClass2.INSTANCE;
    L9:
        if ((r14 & 4) == 0) goto L11;
        r13 = AnonymousClass3.INSTANCE;
    L11:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "beforeTextChanged");
        Intrinsics.checkNotNullParameter(r12, "onTextChanged");
        Intrinsics.checkNotNullParameter(r13, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 r16 = new TextViewKt$addTextChangedListener$textWatcher$1(r13, r11, r12);
        r10.addTextChangedListener(r16);
        return r16;
    }

    public static final TextWatcher doAfterTextChanged(TextView r10, final Function1<? super Editable, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        TextWatcher r12 = new TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1(r11);
        r10.addTextChangedListener(r12);
        return r12;
    }

    public static final TextWatcher doBeforeTextChanged(TextView r10, final Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        TextWatcher r12 = new TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1(r11);
        r10.addTextChangedListener(r12);
        return r12;
    }

    public static final TextWatcher doOnTextChanged(TextView r10, final Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        TextWatcher r12 = new TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1(r11);
        r10.addTextChangedListener(r12);
        return r12;
    }
}

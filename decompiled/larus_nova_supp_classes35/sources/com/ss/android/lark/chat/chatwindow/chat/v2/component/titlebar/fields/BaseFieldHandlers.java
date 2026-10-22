package com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields;

import androidx.collection.SparseArrayCompat;
import com.ss.android.lark.profile.v2.entity.BaseField;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class BaseFieldHandlers {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(BaseFieldHandlers$fieldHandlers$2.INSTANCE);
    }

    public static String a(BaseField r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Function1 r0 = (Function1) ((SparseArrayCompat) a.getValue()).get(r2.getFieldType());
        if (r0 != null) goto L7;
        return null;
    L7:
        return (String) r0.invoke(r2);
    }
}

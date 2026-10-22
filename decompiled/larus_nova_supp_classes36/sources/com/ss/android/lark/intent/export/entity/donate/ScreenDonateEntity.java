package com.ss.android.lark.intent.export.entity.donate;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH&¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/donate/ScreenDonateEntity;", "", "type", "Lcom/ss/android/lark/intent/export/entity/donate/DonateType;", "<init>", "(Lcom/ss/android/lark/intent/export/entity/donate/DonateType;)V", "getType", "()Lcom/ss/android/lark/intent/export/entity/donate/DonateType;", "parser", "R", "visitor", "Lcom/ss/android/lark/intent/export/entity/donate/IDonateEntityVisitor;", "(Lcom/ss/android/lark/intent/export/entity/donate/IDonateEntityVisitor;)Ljava/lang/Object;", "toDesc", "", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public abstract class ScreenDonateEntity {
    private final DonateType type;

    public abstract <R> R parser(IDonateEntityVisitor<R> r1);

    public abstract String toDesc();

    public final DonateType getType() {
        return this.type;
    }

    public ScreenDonateEntity(DonateType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.type = r2;
    }
}

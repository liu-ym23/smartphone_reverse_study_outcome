package com.ss.android.lark.intent.export.entity.donate;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0007H&¢\u0006\u0002\u0010\bJ\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\tH&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/donate/IDonateEntityVisitor;", "R", "", "visit", "entity", "Lcom/ss/android/lark/intent/export/entity/donate/ChatDonateEntity;", "(Lcom/ss/android/lark/intent/export/entity/donate/ChatDonateEntity;)Ljava/lang/Object;", "Lcom/ss/android/lark/intent/export/entity/donate/ChatterDonateEntity;", "(Lcom/ss/android/lark/intent/export/entity/donate/ChatterDonateEntity;)Ljava/lang/Object;", "Lcom/ss/android/lark/intent/export/entity/donate/DocDonateEntity;", "(Lcom/ss/android/lark/intent/export/entity/donate/DocDonateEntity;)Ljava/lang/Object;", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public interface IDonateEntityVisitor<R> {
    R visit(ChatDonateEntity r1);

    R visit(ChatterDonateEntity r1);

    R visit(DocDonateEntity r1);
}

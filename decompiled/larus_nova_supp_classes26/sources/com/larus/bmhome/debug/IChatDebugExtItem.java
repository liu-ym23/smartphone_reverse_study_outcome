package com.larus.bmhome.debug;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/debug/IChatDebugExtItem;", "", "priority", "", "supplyItemTitle", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "messageId", "", "supplyItemGroup", "Landroid/widget/LinearLayout;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IChatDebugExtItem {
    LinearLayout a(Context r1, String r2);

    AppCompatTextView b(Context r1, String r2);

    void priority();
}

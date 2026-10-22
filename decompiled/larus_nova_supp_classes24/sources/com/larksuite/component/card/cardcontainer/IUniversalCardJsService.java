package com.larksuite.component.card.cardcontainer;

import android.content.Context;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¨\u0006\r"}, d2 = {"Lcom/larksuite/component/card/cardcontainer/IUniversalCardJsService;", "", "getJsBundleVersion", "", "context", "Landroid/content/Context;", "getJsBundleFile", "initCardEnv", "", "loadTemplate", "", "mainJsFile", "Ljava/io/File;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public interface IUniversalCardJsService {
    String getJsBundleFile(Context r1);

    String getJsBundleVersion(Context r1);

    void initCardEnv(Context r1);

    byte[] loadTemplate(Context r1, File r2);
}

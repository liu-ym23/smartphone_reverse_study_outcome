package com.obric.oui.panel.header;

import android.view.View;
import com.obric.oui.titlebar.ONormalTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/panel/header/BasicPanelNormalTitleBarHeader;", "Lcom/obric/oui/panel/header/BasicPanelHeader;", "context", "Landroid/content/Context;", "useAutoSwitchTheme", "", "(Landroid/content/Context;Z)V", "titleBar", "Lcom/obric/oui/titlebar/ONormalTitleBar;", "titleOnPad", "", "getTitleOnPad", "()Ljava/lang/String;", "setTitleOnPad", "(Ljava/lang/String;)V", "getTitleBar", "getView", "Landroid/view/View;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ONormalTitleBar f14284a;

    @Override // com.obric.oui.panel.header.c
    public View a() {
        return (View) ZeusTransformUtils.preCheckCast(this.f14284a, View.class, "com.obric.memorydata.plugin");
    }
}

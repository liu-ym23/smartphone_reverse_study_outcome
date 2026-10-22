package com.ivy.ivykit.api.plugin;

import android.content.Context;
import androidx.annotation.Keep;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 !2\u00020\u0001:\u0001\"J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJE\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\fH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/ivy/ivykit/api/plugin/IvyPluginService;", "", "Lcom/ivy/ivykit/api/plugin/h;", "pluginConfig", "", "initContainer", "(Lcom/ivy/ivykit/api/plugin/h;)V", "", "hasInit", "()Z", "Landroid/content/Context;", "context", "", "templateUrl", "Lol/b;", "loadingView", "Lol/c;", "pluginViewLifeCycle", "initData", "Lql/a;", "createPluginView", "(Landroid/content/Context;Ljava/lang/String;Lol/b;Lol/c;Ljava/lang/String;)Lql/a;", "", "schemaList", "preload", "(Ljava/util/List;)V", "url", "openSchema", "(Landroid/content/Context;Ljava/lang/String;)V", "Lpl/a;", "config", "setLynxVerifyConfig", "(Lpl/a;)V", "Companion", "com/ivy/ivykit/api/plugin/f", "ivy_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IvyPluginService {
    public static final f Companion = null;

    static {
        Companion = f.f9491a;
    }

    ql.a createPluginView(Context r5, String r10, ol.b r11, ol.c r12, String r13);

    boolean hasInit();

    void initContainer(h r5);

    void openSchema(Context r5, String r10);

    void preload(List<String> r5);

    void setLynxVerifyConfig(pl.a r5);
}

package com.obric.widget.host;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.RequiresOptIn;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/widget/host/WidgetHostImplementationApi;", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@RequiresOptIn(level = RequiresOptIn.Level.WARNING, message = "This API is only for WidgetHost implementations. Product hosts should use WidgetHostRuntime.createHost(), WidgetHost and HostedWidget.")
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
public @interface WidgetHostImplementationApi {
}

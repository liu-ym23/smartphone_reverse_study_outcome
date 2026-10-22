package com.ss.android.lark.chameleon.pluginsystem;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class WebPluginHost extends PluginHost {

    /* JADX INFO: renamed from: web, reason: collision with root package name */
    private Web f8web;

    public Web getWeb() {
        return this.f8web;
    }

    public WebPluginHost(Web r1) {
        this.f8web = r1;
    }

    public void setWeb(Web r1) {
        this.f8web = r1;
    }
}

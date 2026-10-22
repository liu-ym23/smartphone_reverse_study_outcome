package com.ivy.ivykit.plugin.impl.web;

import android.content.Intent;
import android.webkit.WebChromeClient;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends WebChromeClient.FileChooserParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ym.d f9536a;

    public c(ym.d r5) {
        this.f9536a = r5;
    }

    @Override // android.webkit.WebChromeClient.FileChooserParams
    public final Intent createIntent() {
        ym.d r5 = this.f9536a;
        if (r5 == null) goto L9;
        Intent r10 = ((WebChromeClient.FileChooserParams) r5.f23297a).createIntent();
        if (r10 == null) goto L9;
        return r10;
    L9:
        return new Intent();
    }

    @Override // android.webkit.WebChromeClient.FileChooserParams
    public final String[] getAcceptTypes() {
        ym.d r5 = this.f9536a;
        if (r5 == null) goto L9;
        String[] r10 = ((WebChromeClient.FileChooserParams) r5.f23297a).getAcceptTypes();
        if (r10 == null) goto L9;
        return r10;
    L9:
        return new String[0];
    }

    @Override // android.webkit.WebChromeClient.FileChooserParams
    public final String getFilenameHint() {
        ym.d r5 = this.f9536a;
        if (r5 == null) goto L8;
        String r10 = ((WebChromeClient.FileChooserParams) r5.f23297a).getFilenameHint();
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.toString();
    L8:
        return null;
    }

    @Override // android.webkit.WebChromeClient.FileChooserParams
    public final int getMode() {
        ym.d r5 = this.f9536a;
        if (r5 != null) goto L5;
        return 0;
    L5:
        return ((WebChromeClient.FileChooserParams) r5.f23297a).getMode();
    }

    @Override // android.webkit.WebChromeClient.FileChooserParams
    public final CharSequence getTitle() {
        ym.d r5 = this.f9536a;
        if (r5 != null) goto L5;
        return null;
    L5:
        return ((WebChromeClient.FileChooserParams) r5.f23297a).getTitle();
    }

    @Override // android.webkit.WebChromeClient.FileChooserParams
    public final boolean isCaptureEnabled() {
        ym.d r5 = this.f9536a;
        if (r5 != null) goto L5;
        return false;
    L5:
        return ((WebChromeClient.FileChooserParams) r5.f23297a).isCaptureEnabled();
    }
}

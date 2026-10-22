package com.bytedance.ai.view.popup.params;

import com.bytedance.ai.view.popup.anim.AnimationStyle;
import h3.d;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/view/popup/params/AbsAppletPopupSchemaParam;", "Ljava/io/Serializable;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsAppletPopupSchemaParam implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2889c;
    public int d;
    public final int e;
    public int f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2890h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2891i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f2892j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f2893k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f2894l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f2895m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2896n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2897o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f2898p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2899q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f2900r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f2901t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2902u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f2903v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2904w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f2905x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f2906y;

    public AbsAppletPopupSchemaParam() {
        this.f2887a = "bottom";
        this.f2888b = d.f17275a;
        this.f2889c = -1;
        this.d = d.f17276b;
        this.e = -1;
        this.f = 8;
        AnimationStyle[] r5 = AnimationStyle.f2882a;
        this.f2892j = "auto";
        this.f2893k = "auto";
        this.f2894l = "";
        this.f2895m = "";
        this.f2897o = -1;
        this.f2898p = d.f17277c;
        this.f2900r = true;
        this.f2901t = 1;
        this.f2905x = true;
    }
}

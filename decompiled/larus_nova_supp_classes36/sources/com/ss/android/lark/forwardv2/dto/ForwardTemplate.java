package com.ss.android.lark.forwardv2.dto;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv2.dto.template.BusinessRecentVisitEnableConfig;
import com.ss.android.lark.forwardv2.dto.template.BusinessRecentVisitIncludeConfig;
import com.ss.android.lark.forwardv2.dto.template.ForwardFeature;
import com.ss.android.lark.forwardv2.dto.template.ForwardHitPoint;
import com.ss.android.lark.forwardv2.dto.template.ForwardLaunchParam;
import com.ss.android.lark.forwardv2.dto.template.ForwardTargetFilter;
import com.ss.android.lark.forwardv2.dto.template.ForwardViewDependency;
import com.ss.android.lark.forwardv2.dto.template.IForwardProxyExecutor;
import com.ss.android.lark.forwardv2.dto.template.choosechat.PreSelectedPair;
import com.ss.android.lark.forwardv2.dto.template.config.EntityItem;
import com.ss.android.lark.forwardv2.impl.RemoteForwardExecutor;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ForwardTemplate implements Parcelable {
    public static final Parcelable.Creator<ForwardTemplate> CREATOR = null;
    public BusinessRecentVisitIncludeConfig a;
    public BusinessRecentVisitEnableConfig b;
    public ForwardFeature c;
    public ForwardTargetFilter d;
    public ForwardViewDependency e;
    public ForwardHitPoint f;
    public Bundle g;
    public ForwardLaunchParam h;
    public com.ss.android.lark.forwardv2.dto.template.b i;
    public final RemoteForwardExecutor j;
    public final IForwardProxyExecutor k;

    public class a implements Parcelable.Creator<ForwardTemplate> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTemplate createFromParcel(Parcel r2) {
            return new ForwardTemplate(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTemplate[] newArray(int r1) {
            return new ForwardTemplate[r1];
        }
    }

    public static class b {
        public BusinessRecentVisitIncludeConfig a;
        public BusinessRecentVisitEnableConfig b;
        public ForwardFeature c;
        public ForwardTargetFilter d;
        public ForwardViewDependency e;
        public ForwardHitPoint f;
        public ForwardLaunchParam g;
        public Bundle h;

        public b() {
        }

        public final ForwardTemplate a(com.ss.android.lark.forwardv2.dto.template.b r6) {
            ForwardTemplate r0 = new ForwardTemplate(r6);
            if (this.b != null) goto L6;
            ArrayList<EntityItem> r7 = new ArrayList();
            BusinessRecentVisitEnableConfig r1 = new BusinessRecentVisitEnableConfig();
            r1.c = r7;
            this.b = r1;
        L6:
            if (this.a != null) goto L9;
            ArrayList<EntityItem> r8 = new ArrayList();
            BusinessRecentVisitIncludeConfig r2 = new BusinessRecentVisitIncludeConfig();
            r2.a = r8;
            this.a = r2;
        L9:
            if (this.c != null) goto L12;
            ArrayList<PreSelectedPair> r9 = new ArrayList();
            ForwardFeature r4 = new ForwardFeature();
            r4.a = r9;
            r4.b = true;
            r4.c = true;
            r4.d = true;
            r4.e = 10;
            r4.f = true;
            r4.j = true;
            r4.g = true;
            r4.h = true;
            r4.i = false;
            r4.k = false;
            r4.m = null;
            r4.n = null;
            r4.l = false;
            this.c = r4;
        L12:
            if (this.d != null) goto L15;
            ForwardTargetFilter r10 = new ForwardTargetFilter();
            r10.a = false;
            r10.b = false;
            r10.d = true;
            r10.c = false;
            r10.e = false;
            r10.f = false;
            r10.g = true;
            r10.i = false;
            r10.h = true;
            r10.j = false;
            this.d = r10;
        L15:
            if (this.e != null) goto L18;
            ForwardViewDependency r11 = new ForwardViewDependency();
            r11.i = true;
            r11.d = null;
            r11.e = null;
            r11.a = true;
            r11.b = null;
            r11.c = null;
            r11.f = null;
            r11.g = null;
            r11.h = null;
            r11.j = true;
            this.e = r11;
        L18:
            if (this.f != null) goto L21;
            ForwardHitPoint.a r12 = new ForwardHitPoint.a();
            ForwardHitPoint r3 = new ForwardHitPoint();
            r3.a = null;
            r3.b = INotificationHitPoint.NoticeType.OTHER;
            r3.c = null;
            r3.d = r12.a;
            r3.e = r12.b;
            r3.f = r12.c;
            this.f = r3;
        L21:
            if (this.g != null) goto L23;
            ForwardLaunchParam r13 = new ForwardLaunchParam();
            r13.a = 0;
            this.g = r13;
        L23:
            r0.b = this.b;
            r0.a = this.a;
            r0.c = this.c;
            r0.d = this.d;
            r0.e = this.e;
            r0.f = this.f;
            r0.g = this.h;
            r0.h = this.g;
            return r0;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ForwardTemplate(Parcel r3) {
        this.b = (BusinessRecentVisitEnableConfig) r3.readParcelable(ForwardTemplate.class.getClassLoader());
        this.a = (BusinessRecentVisitIncludeConfig) r3.readParcelable(ForwardTemplate.class.getClassLoader());
        this.c = (ForwardFeature) r3.readParcelable(ForwardTemplate.class.getClassLoader());
        this.d = (ForwardTargetFilter) r3.readParcelable(ForwardTemplate.class.getClassLoader());
        this.e = (ForwardViewDependency) r3.readParcelable(ForwardTemplate.class.getClassLoader());
        this.f = (ForwardHitPoint) r3.readParcelable(ForwardTemplate.class.getClassLoader());
        this.h = (ForwardLaunchParam) r3.readParcelable(ForwardTemplate.class.getClassLoader());
        if (r3.readInt() != 1) goto L5;
        this.j = RemoteForwardExecutor.Stub.asInterface(r3.readStrongBinder());
    L6:
        this.k = (IForwardProxyExecutor) r3.readParcelable(ForwardTemplate.class.getClassLoader());
        this.g = r3.readBundle(ForwardTemplate.class.getClassLoader());
        return;
    L5:
        this.j = null;
        goto L6
    }

    public ForwardTemplate(final com.ss.android.lark.forwardv2.dto.template.b r2) {
        this.i = r2;
        this.j = new AnonymousClass1(this, r2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        r2.writeParcelable(this.b, r3);
        r2.writeParcelable(this.a, r3);
        r2.writeParcelable(this.c, r3);
        r2.writeParcelable(this.d, r3);
        r2.writeParcelable(this.e, r3);
        r2.writeParcelable(this.f, r3);
        r2.writeParcelable(this.h, r3);
        if (this.j == null) goto L5;
        r2.writeInt(1);
        r2.writeStrongBinder(this.j.asBinder());
    L6:
        r2.writeParcelable(this.k, r3);
        r2.writeBundle(this.g);
        return;
    L5:
        r2.writeInt(0);
        goto L6
    }
}

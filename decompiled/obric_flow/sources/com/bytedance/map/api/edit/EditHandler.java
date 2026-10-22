package com.bytedance.map.api.edit;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import com.bytedance.amap.model.AliMarker;
import com.bytedance.amap.model.AliPolygon;
import com.bytedance.lynx.map.ng.LynxMapView;
import com.bytedance.map.api.BDMapClient;
import com.bytedance.map.api.IMapService;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.BDMarkerOptions;
import com.bytedance.map.api.model.IMarker;
import com.bytedance.map.api.model.IPolygon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class EditHandler {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static int f6884t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BDMapClient f6886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LynxMapView f6887c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6888h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6889i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6890j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6891k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6892l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6893m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6894n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6895o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public IPolygon f6896p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList f6897q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final HashMap f6898r;
    public final ArrayList s;

    public EditHandler(Context r5, BDMapClient r10) {
        this.d = false;
        this.e = true;
        this.f = true;
        this.g = false;
        this.f6888h = 0;
        this.f6889i = 0;
        this.f6890j = 0;
        this.f6891k = 0;
        this.f6894n = -1;
        this.f6897q = new ArrayList();
        this.f6898r = new HashMap();
        this.s = new ArrayList();
        this.f6885a = r5;
        this.f6886b = r10;
        f6884t = (int) ((r5.getResources().getDisplayMetrics().density * 30.0f) + 0.5f);
    }

    public final void a(IPolygon r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.equals(this.f6896p) == false) goto L20;
        this.f6896p = null;
        Iterator r10 = this.s.iterator();
    L8:
        if (r10.hasNext() == false) goto L12;
        IMarker r11 = (IMarker) r10.next();
        if (r11 == null) goto L8;
        ((AliMarker) r11).a();
        goto L8
    L12:
        this.s.clear();
        this.f6897q.clear();
        this.d = false;
        this.e = true;
        this.f = true;
        this.g = false;
        return;
    }

    public final void a(BDLatLng r10) {
        int r5 = this.f6897q.size();
        int r11 = this.f6894n;
        int r12 = ((r11 - 2) + r5) % r5;
        int r13 = ((r11 - 1) + r5) % r5;
        BDLatLng r14 = a((BDLatLng) this.f6897q.get(r12), r10);
        ((AliMarker) ((IMarker) this.s.get(r13))).a(r14);
        this.f6897q.remove(r13);
        int r15 = 0;
        this.f6897q.add(r13, new BDLatLng(r14, false));
        int r16 = this.f6894n;
        ((AliMarker) ((IMarker) this.s.get(r16))).a(r10);
        this.f6897q.remove(r16);
        this.f6897q.add(r16, new BDLatLng(r10, true));
        int r17 = this.f6894n;
        int r18 = ((r17 + 2) + r5) % r5;
        int r19 = ((r17 + 1) + r5) % r5;
        BDLatLng r20 = a((BDLatLng) this.f6897q.get(r18), r10);
        ((AliMarker) ((IMarker) this.s.get(r19))).a(r20);
        this.f6897q.remove(r19);
        this.f6897q.add(r19, new BDLatLng(r20, false));
        if (this.f6896p != null) goto L5;
        return;
    L5:
        ArrayList r21 = new ArrayList();
    L7:
        if (r15 >= this.f6897q.size()) goto L9;
        r21.add(this.f6897q.get(r15));
        r15 = r15 + 2;
        goto L7
    L9:
        ((AliPolygon) this.f6896p).a(r21);
    }

    public final IMarker a(BDLatLng r5, View r10) {
        BDMarkerOptions r11 = new BDMarkerOptions();
        r11.f6921b = r5;
        r11.d = r10;
        IMapService r12 = this.f6886b.f6862a;
        if (r12 != null) goto L7;
        return null;
    L7:
        return r12.addMarker(r11);
    }

    public final BDLatLng a(BDLatLng r10, BDLatLng r11) {
        IMapService r5 = this.f6886b.f6862a;
        if (r5 != null) goto L5;
        Point r12 = null;
    L6:
        IMapService r13 = this.f6886b.f6862a;
        if (r13 != null) goto L9;
        Point r14 = null;
    L11:
        if (r12 != null) goto L13;
        r12 = new Point(0, 0);
    L13:
        if (r14 != null) goto L15;
        r14 = new Point(0, 0);
    L15:
        int r15 = r12.x;
        int r16 = r14.x;
        int r17 = r12.y;
        int r18 = r14.y;
        Point r19 = new Point((r15 & r16) + ((r15 ^ r16) >> 1), (r17 & r18) + ((r17 ^ r18) >> 1));
        IMapService r20 = this.f6886b.f6862a;
        if (r20 != null) goto L19;
        return null;
    L19:
        return r20.transPointToLatLng(r19);
    L9:
        r14 = r13.transLatLngToPoint(r11);
        goto L11
    L5:
        r12 = r5.transLatLngToPoint(r10);
        goto L6
    }
}

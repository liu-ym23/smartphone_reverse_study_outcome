package com.bytedance.android.ec.common.api.abilities;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import cf.u;
import com.bytedance.android.ec.core.event.a;
import df.b;
import df.c;
import df.d;
import df.e;
import df.f;
import df.g;
import df.h;
import df.i;
import df.j;
import df.k;
import df.l;
import df.m;
import df.n;
import df.o;
import df.p;
import df.r;
import df.s;
import df.t;
import df.v;
import df.w;
import df.x;
import df.y;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J6\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH&J2\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u000eH&J*\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&J,\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&J*\u0010$\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\"H&J\u0018\u0010)\u001a\u00020\f2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H&J(\u00102\u001a\u00020\f2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200H&J*\u0010:\u001a\u0004\u0018\u0001092\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u0002052\u0006\u00108\u001a\u000207H&J(\u0010@\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=2\u0006\u00108\u001a\u00020?H&J*\u0010F\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010B\u001a\u00020A2\u0006\u0010D\u001a\u00020C2\b\u00108\u001a\u0004\u0018\u00010EH&J\u001c\u0010I\u001a\u00020\f2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0GH&¨\u0006J"}, d2 = {"Lcom/bytedance/android/ec/common/api/abilities/IShoppingAbilities;", "", "Landroid/content/Context;", "context", "Ldf/r;", "pdpRequired", "Ldf/p;", "pdpOptional", "Ldf/s;", "pdpResult", "Lze/a;", "preloadStrategy", "", "preloadPDP", "", a.KEY_SCHEMA, "preloadPdpBySchema", "openPDP", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Ldf/v;", "skuRequired", "Ldf/u;", "skuOptional", "Ldf/t;", "skuResult", "Lcf/u;", "openSKU", "Landroid/view/View;", "view", "Ldf/b;", "addCartRequired", "Ldf/a;", "addCartOptional", "Ldf/c;", "addCartResult", "addCartDirectly", "Ldf/o;", "orderRequired", "Ldf/n;", "orderOptional", "submitOrderDirectly", "Ldf/g;", "ecShareResources", "Ldf/y;", "shareRequired", "Ldf/x;", "shareOptional", "Ldf/w;", "shareCallback", "pdpShare", "Ldf/f;", "collectRequired", "Ldf/e;", "collectOptional", "Ldf/d;", "callbacks", "Lio/reactivex/disposables/Disposable;", "pdpCollect", "Ldf/m;", "imRequired", "Ldf/l;", "imOptional", "Ldf/k;", "openIM", "Ldf/j;", "cartRequired", "Ldf/i;", "cartOptional", "Ldf/h;", "enterCart", "Lkotlin/Function1;", "watch", "watchPDPAction", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public interface IShoppingAbilities {
    void addCartDirectly(View r1, b r10, df.a r11, c r12);

    void enterCart(Context r1, j r10, i r11, h r12);

    void openIM(Context r1, m r10, l r11, k r12);

    void openPDP(Context r1, r r10, p r11, s r12);

    u openSKU(FragmentManager r1, v r10, df.u r11, t r12);

    Disposable pdpCollect(Context r1, f r10, e r11, d r12);

    void pdpShare(g r1, y r10, x r11, w r12);

    void preloadPDP(Context r1, r r10, p r11, s r12, ze.a r13);

    void preloadPdpBySchema(Context r1, r r10, p r11, s r12, String r13);

    void submitOrderDirectly(o r1, n r10);

    void watchPDPAction(Function1<Object, Unit> r1);
}

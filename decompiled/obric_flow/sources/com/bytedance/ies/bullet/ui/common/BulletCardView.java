package com.bytedance.ies.bullet.ui.common;

import ai.j0;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.m;
import com.bytedance.android.anniex.container.ui.AnnieXSourceLabel;
import com.bytedance.ies.bullet.base.core.common.Components;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.i;
import com.bytedance.ies.bullet.core.n;
import com.bytedance.ies.bullet.core.o;
import com.bytedance.ies.bullet.prefetchv2.l;
import com.bytedance.ies.bullet.service.base.CacheType;
import com.bytedance.ies.bullet.service.base.YieldError;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.v0;
import com.lynx.tasm.ui.image.f0;
import com.obric.launcher.widget.R$dimen;
import com.obric.launcher.widget.R$id;
import com.obric.launcher.widget.R$layout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\rH\u0007¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\rH\u0016¢\u0006\u0004\b!\u0010\u000fJ\u000f\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\"\u0010#R\u001a\u0010)\u001a\u00020$8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\"\u00101\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00109\u001a\u0004\u0018\u0001028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010?\u001a\u0004\u0018\u00010\u00138\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010\u0015\"\u0004\b=\u0010>R\u001d\u0010E\u001a\u0004\u0018\u00010@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\"\u0010I\u001a\u00020F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001b\u0010Q\u001a\u00020M8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bN\u0010B\u001a\u0004\bO\u0010PR.\u0010Z\u001a\u0004\u0018\u00010R2\b\u0010S\u001a\u0004\u0018\u00010R8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010b\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010a¨\u0006c"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/BulletCardView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ies/bullet/core/container/e;", "Lcom/bytedance/ies/bullet/core/n;", "Lrc/f;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "getBid", "()Ljava/lang/String;", "Lcom/bytedance/ies/bullet/core/e;", "getBulletContext", "()Lcom/bytedance/ies/bullet/core/e;", "Landroid/net/Uri;", "getCurrentUri", "()Landroid/net/Uri;", "getProcessingUri", "Lcom/bytedance/ies/bullet/service/base/h;", "getKitView", "()Lcom/bytedance/ies/bullet/service/base/h;", "Lrd/e;", "getSchemaModelUnion", "()Lrd/e;", "id", "", "setSessionId", "(Ljava/lang/String;)V", "getSessionId", "getPoolBulletLifeCycle", "()Lcom/bytedance/ies/bullet/core/n;", "Lrb/b;", "b", "Lrb/b;", "getProviderFactory", "()Lrb/b;", "providerFactory", "Lcom/bytedance/ies/bullet/core/common/Scenes;", "f", "Lcom/bytedance/ies/bullet/core/common/Scenes;", "getMCurrentScene", "()Lcom/bytedance/ies/bullet/core/common/Scenes;", "setMCurrentScene", "(Lcom/bytedance/ies/bullet/core/common/Scenes;)V", "mCurrentScene", "Lvc/c;", "m", "Lvc/c;", "getLynxClient", "()Lvc/c;", "setLynxClient", "(Lvc/c;)V", "lynxClient", "n", "Landroid/net/Uri;", "getUri", "setUri", "(Landroid/net/Uri;)V", LynxResourceModule.URI_KEY, "Landroid/view/View;", "s", "Lkotlin/Lazy;", "getDecorView", "()Landroid/view/View;", "decorView", "", "t", "Z", "isAutoReleasableWhenDetached", "()Z", "setAutoReleasableWhenDetached", "(Z)V", "Lrc/e;", "x", "getServiceContext", "()Lrc/e;", "serviceContext", "Lcom/bytedance/ies/bullet/core/container/c;", "value", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/bytedance/ies/bullet/core/container/c;", "getActivityWrapper", "()Lcom/bytedance/ies/bullet/core/container/c;", "setActivityWrapper", "(Lcom/bytedance/ies/bullet/core/container/c;)V", "activityWrapper", "Lwd/a;", "C", "Lwd/a;", "getEventInterceptor", "()Lwd/a;", "setEventInterceptor", "(Lwd/a;)V", "eventInterceptor", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nBulletCardView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BulletCardView.kt\ncom/bytedance/ies/bullet/ui/common/BulletCardView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Yield.kt\ncom/bytedance/ies/bullet/service/base/YieldKt\n+ 5 Cast.kt\ncom/ss/android/ugc/aweme/uncheckedcast/CastKt\n*L\n1#1,1683:1\n1528#1:1690\n1529#1:1694\n1530#1,2:1696\n1532#1:1699\n1533#1:1702\n1528#1:1703\n1529#1:1707\n1530#1,2:1709\n1532#1:1712\n1533#1:1715\n1528#1:1716\n1529#1:1720\n1530#1,2:1722\n1532#1:1725\n1533#1:1728\n1517#1:1729\n1518#1:1733\n1519#1,2:1735\n1521#1,4:1738\n1525#1:1744\n1517#1:1748\n1518#1:1752\n1519#1,2:1754\n1521#1,4:1757\n1525#1:1763\n1517#1:1764\n1518#1:1768\n1519#1,2:1770\n1521#1,4:1773\n1525#1:1779\n1517#1:1780\n1518#1:1784\n1519#1,2:1786\n1521#1,4:1789\n1525#1:1795\n1517#1:1796\n1518#1:1800\n1519#1,2:1802\n1521#1,4:1805\n1525#1:1811\n1517#1:1812\n1518#1:1816\n1519#1,2:1818\n1521#1,4:1821\n1525#1:1827\n1517#1:1828\n1518#1:1832\n1519#1,2:1834\n1521#1,4:1837\n1525#1:1843\n1528#1:1844\n1529#1:1848\n1530#1,2:1850\n1532#1:1853\n1533#1:1856\n1528#1:1857\n1529#1:1861\n1530#1,2:1863\n1532#1:1866\n1533#1:1869\n1528#1:1872\n1529#1:1876\n1530#1,2:1878\n1532#1:1881\n1533#1:1884\n1517#1:1885\n1518#1:1889\n1519#1,2:1891\n1521#1,4:1894\n1525#1:1900\n1517#1:1901\n1518#1:1905\n1519#1,2:1907\n1521#1,4:1910\n1525#1:1916\n256#2,2:1684\n1828#2,3:1686\n1819#2:1695\n1820#2:1698\n1819#2:1708\n1820#2:1711\n1819#2:1721\n1820#2:1724\n1819#2:1734\n1820#2:1737\n1819#2:1753\n1820#2:1756\n1819#2:1769\n1820#2:1772\n1819#2:1785\n1820#2:1788\n1819#2:1801\n1820#2:1804\n1819#2:1817\n1820#2:1820\n1819#2:1833\n1820#2:1836\n1819#2:1849\n1820#2:1852\n1819#2:1862\n1820#2:1865\n1819#2,2:1870\n1819#2:1877\n1820#2:1880\n1819#2:1890\n1820#2:1893\n1819#2:1906\n1820#2:1909\n734#2:1917\n825#2,2:1918\n1819#2,2:1920\n1819#2,2:1925\n1819#2,2:1927\n1819#2,2:1934\n1#3:1689\n10#4,3:1691\n13#4,2:1700\n10#4,3:1704\n13#4,2:1713\n10#4,3:1717\n13#4,2:1726\n10#4,3:1730\n13#4,2:1742\n10#4,3:1749\n13#4,2:1761\n10#4,3:1765\n13#4,2:1777\n10#4,3:1781\n13#4,2:1793\n10#4,3:1797\n13#4,2:1809\n10#4,3:1813\n13#4,2:1825\n10#4,3:1829\n13#4,2:1841\n10#4,3:1845\n13#4,2:1854\n10#4,3:1858\n13#4,2:1867\n10#4,3:1873\n13#4,2:1882\n10#4,3:1886\n13#4,2:1898\n10#4,3:1902\n13#4,2:1914\n10#4,3:1922\n13#4,2:1929\n10#4,3:1931\n13#4,2:1936\n4#5:1745\n4#5:1746\n4#5:1747\n*E\n*S KotlinDebug\n*F\n+ 1 BulletCardView.kt\ncom/bytedance/ies/bullet/ui/common/BulletCardView\n*L\n765#1:1690\n765#1:1694\n765#1,2:1696\n765#1:1699\n765#1:1702\n772#1:1703\n772#1:1707\n772#1,2:1709\n772#1:1712\n772#1:1715\n781#1:1716\n781#1:1720\n781#1,2:1722\n781#1:1725\n781#1:1728\n825#1:1729\n825#1:1733\n825#1,2:1735\n825#1,4:1738\n825#1:1744\n856#1:1748\n856#1:1752\n856#1,2:1754\n856#1,4:1757\n856#1:1763\n906#1:1764\n906#1:1768\n906#1,2:1770\n906#1,4:1773\n906#1:1779\n925#1:1780\n925#1:1784\n925#1,2:1786\n925#1,4:1789\n925#1:1795\n932#1:1796\n932#1:1800\n932#1,2:1802\n932#1,4:1805\n932#1:1811\n984#1:1812\n984#1:1816\n984#1,2:1818\n984#1,4:1821\n984#1:1827\n988#1:1828\n988#1:1832\n988#1,2:1834\n988#1,4:1837\n988#1:1843\n995#1:1844\n995#1:1848\n995#1,2:1850\n995#1:1853\n995#1:1856\n1000#1:1857\n1000#1:1861\n1000#1,2:1863\n1000#1:1866\n1000#1:1869\n1120#1:1872\n1120#1:1876\n1120#1,2:1878\n1120#1:1881\n1120#1:1884\n1400#1:1885\n1400#1:1889\n1400#1,2:1891\n1400#1,4:1894\n1400#1:1900\n1418#1:1901\n1418#1:1905\n1418#1,2:1907\n1418#1,4:1910\n1418#1:1916\n398#1,2:1684\n437#1,3:1686\n765#1:1695\n765#1:1698\n772#1:1708\n772#1:1711\n781#1:1721\n781#1:1724\n825#1:1734\n825#1:1737\n856#1:1753\n856#1:1756\n906#1:1769\n906#1:1772\n925#1:1785\n925#1:1788\n932#1:1801\n932#1:1804\n984#1:1817\n984#1:1820\n988#1:1833\n988#1:1836\n995#1:1849\n995#1:1852\n1000#1:1862\n1000#1:1865\n1033#1,2:1870\n1120#1:1877\n1120#1:1880\n1400#1:1890\n1400#1:1893\n1418#1:1906\n1418#1:1909\n1470#1:1917\n1470#1,2:1918\n1470#1,2:1920\n1518#1,2:1925\n1521#1,2:1927\n1529#1,2:1934\n765#1,3:1691\n765#1,2:1700\n772#1,3:1704\n772#1,2:1713\n781#1,3:1717\n781#1,2:1726\n825#1,3:1730\n825#1,2:1742\n856#1,3:1749\n856#1,2:1761\n906#1,3:1765\n906#1,2:1777\n925#1,3:1781\n925#1,2:1793\n932#1,3:1797\n932#1,2:1809\n984#1,3:1813\n984#1,2:1825\n988#1,3:1829\n988#1,2:1841\n995#1,3:1845\n995#1,2:1854\n1000#1,3:1858\n1000#1,2:1867\n1120#1,3:1873\n1120#1,2:1882\n1400#1,3:1886\n1400#1,2:1898\n1418#1,3:1902\n1418#1,2:1914\n1517#1,3:1922\n1517#1,2:1929\n1528#1,3:1931\n1528#1,2:1936\n838#1:1745\n841#1:1746\n843#1:1747\n*E\n"})
public class BulletCardView extends FrameLayout implements com.bytedance.ies.bullet.core.container.e, n, rc.f {
    public static boolean D;
    public com.bytedance.ies.bullet.core.container.c A;
    public final sj.e B;
    public wd.a C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedHashMap f6167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rb.b f6168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public rb.b f6169c;
    public com.bytedance.ies.bullet.core.e d;
    public final long e;
    public Scenes f;
    public h g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f6170h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f6171i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Orientation f6172j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f6173k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f6174l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public vc.c f6175m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Uri f6176n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicBoolean f6177o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.bytedance.android.anniex.container.f f6178p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LinkedHashMap f6179q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6180r;
    public final Lazy s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f6181t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final AtomicInteger f6182u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AtomicBoolean f6183v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AtomicBoolean f6184w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f6185x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ConcurrentLinkedQueue f6186y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final com.bytedance.ies.bullet.ui.common.loader.c f6187z;

    @JvmOverloads
    public BulletCardView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    private final View getDecorView() {
        return (View) this.s.getValue();
    }

    @Override // rc.f
    public final rc.c a(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        tc.c r10 = tc.c.f22119c;
        return tc.c.f22119c.a(r5, getBid());
    }

    @Override // rc.f
    public final Object b(Class r5) {
        return f0.c(this, r5);
    }

    @Override // com.bytedance.ies.bullet.core.container.e
    public final void c(com.bytedance.ies.bullet.lynx.impl.b r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        h r10 = this.g;
        if (r10 == null) goto L6;
        r10.a(r5.f5650b, (JSONObject) r5.f5651c);
        return;
    }

    @Override // com.bytedance.ies.bullet.core.container.e
    public final void d() {
        com.bytedance.ies.bullet.core.e r5 = this.d;
        String r10 = null;
        if (r5 == null) goto L5;
        com.bytedance.ies.bullet.core.c r11 = r5.f5308w;
    L6:
        if (r11 == null) goto L35;
        r11.g = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
    L35:
        Iterator r12 = this.f6186y.iterator();     // Catch: YieldError -> L34
    L11:
        if (r12.hasNext() == false) goto L15;
        n r13 = (n) r12.next();     // Catch: YieldError -> L34
        if ((r13 instanceof o) == false) goto L11;
        ((o) r13).a();     // Catch: YieldError -> L34
        goto L11
    L15:
        com.bytedance.ies.bullet.core.e r14 = this.d;     // Catch: YieldError -> L34
        if (r14 == null) goto L26;
        ArrayList r15 = r14.f5300n;     // Catch: YieldError -> L34
        if (r15 == null) goto L26;
        Iterator r16 = r15.iterator();     // Catch: YieldError -> L34
    L20:
        if (r16.hasNext() == false) goto L26;
        n r17 = (n) r16.next();     // Catch: YieldError -> L34
        if ((r17 instanceof o) == false) goto L20;
        ((o) r17).a();     // Catch: YieldError -> L34
    L26:
        boolean r18 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.core.e r19 = this.d;
        if (r19 == null) goto L29;
        r10 = r19.getSessionId();
    L29:
        com.bytedance.ies.bullet.service.base.b.b(8, r10, "onEnterForeground", "XView");
        h r20 = this.g;
        if (r20 == null) goto L32;
        r20.d();
    L32:
        xd.c.e.set(false);
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.bytedance.ies.bullet.core.container.e
    public final void e() {
        com.bytedance.ies.bullet.core.e r5 = this.d;
        String r10 = null;
        if (r5 == null) goto L5;
        com.bytedance.ies.bullet.core.c r11 = r5.f5308w;
    L6:
        if (r11 == null) goto L35;
        r11.g = "0";
    L35:
        Iterator r12 = this.f6186y.iterator();     // Catch: YieldError -> L34
    L11:
        if (r12.hasNext() == false) goto L15;
        n r13 = (n) r12.next();     // Catch: YieldError -> L34
        if ((r13 instanceof o) == false) goto L11;
        ((o) r13).c();     // Catch: YieldError -> L34
        goto L11
    L15:
        com.bytedance.ies.bullet.core.e r14 = this.d;     // Catch: YieldError -> L34
        if (r14 == null) goto L26;
        ArrayList r15 = r14.f5300n;     // Catch: YieldError -> L34
        if (r15 == null) goto L26;
        Iterator r16 = r15.iterator();     // Catch: YieldError -> L34
    L20:
        if (r16.hasNext() == false) goto L26;
        n r17 = (n) r16.next();     // Catch: YieldError -> L34
        if ((r17 instanceof o) == false) goto L20;
        ((o) r17).c();     // Catch: YieldError -> L34
    L26:
        boolean r18 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.core.e r19 = this.d;
        if (r19 == null) goto L29;
        r10 = r19.getSessionId();
    L29:
        com.bytedance.ies.bullet.service.base.b.b(8, r10, "onEnterBackground", "XView");
        h r20 = this.g;
        if (r20 == null) goto L32;
        r20.c();
    L32:
        xd.c.e.set(true);
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void f() {
        Iterator r5 = this.f6186y.iterator();     // Catch: YieldError -> L8
    L4:
        if (r5.hasNext() == false) goto L13;
        ((n) r5.next()).f();     // Catch: YieldError -> L8
    L13:
        return;
    }

    public final void g() {
        com.bytedance.ies.bullet.core.e r5 = this.d;
        if (r5 == null) goto L8;
        String r10 = r5.getSessionId();
        if (r10 == null) goto L9;
        com.bytedance.ies.bullet.core.e r11 = this.d;
        Intrinsics.checkNotNull(r11);
        this.f6186y.remove(r11.f5293c.l());
        Lazy r12 = com.bytedance.ies.bullet.core.f.f5312b;
        com.bytedance.ies.bullet.core.f r13 = td.b.b();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        ConcurrentHashMap r14 = r13.f5313a;
        r14.remove(r10);
        boolean r15 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(12, r10, "BulletContextManager removeContextID: " + r14.size(), null);
        cd.a.c(r10);
        ConcurrentHashMap r16 = l.f5865a;
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        l.f5865a.remove(r10);
        return;
    L9:
        return;
    }

    public com.bytedance.ies.bullet.core.container.c getActivityWrapper() {
        return this.A;
    }

    @Override // rc.f
    public Map<Class<?>, Object> getAllDependency() {
        return ((rc.a) getServiceContext()).a();
    }

    @Override // rc.f
    public String getBid() {
        return this.f6170h;
    }

    @Override // com.bytedance.ies.bullet.core.container.e
    public com.bytedance.ies.bullet.core.e getBulletContext() {
        return this.d;
    }

    public Uri getCurrentUri() {
        com.bytedance.ies.bullet.core.e r5 = getBulletContext();
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.f5297k;
    }

    public final wd.a getEventInterceptor() {
        return this.C;
    }

    public h getKitView() {
        return this.g;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public vc.c getLynxClient() {
        return this.f6175m;
    }

    public final Scenes getMCurrentScene() {
        return this.f;
    }

    public final n getPoolBulletLifeCycle() {
        Iterator r5 = this.f6186y.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        n r10 = (n) r5.next();
        if ((r10 instanceof com.bytedance.ies.bullet.pool.a) == false) goto L4;
        return r10;
    L8:
        return null;
    }

    public Uri getProcessingUri() {
        com.bytedance.ies.bullet.core.e r5 = getBulletContext();
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.f5297k;
    }

    public rb.b getProviderFactory() {
        return this.f6168b;
    }

    public rd.e getSchemaModelUnion() {
        com.bytedance.ies.bullet.core.e r5 = this.d;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.g;
    }

    @Override // rc.f
    public rc.e getServiceContext() {
        return (rc.e) this.f6185x.getValue();
    }

    @Override // com.bytedance.ies.bullet.core.container.e
    public String getSessionId() {
        com.bytedance.ies.bullet.core.e r5 = this.d;
        if (r5 == null) goto L6;
        String r10 = r5.getSessionId();
        if (r10 == null) goto L6;
    L7:
        boolean r11 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "getSessionId:".concat(r10), "XView");
        return r10;
    L6:
        r10 = "";
        goto L7
    }

    public final Uri getUri() {
        return this.f6176n;
    }

    public final void h() {
        boolean r5 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.core.e r10 = this.d;
        if (r10 == null) goto L5;
        String r11 = r10.getSessionId();
    L6:
        com.bytedance.ies.bullet.service.base.b.h("onUserCaptureScreen removeScreenCaptureListener", null, null, r11, 110);
        b r12 = this.f6173k;
        if (r12 == null) goto L10;
        h.f.b(new com.bytedance.android.anniex.ui.a(6, this, r12), h.f.g);
        this.f6173k = null;
        return;
    L10:
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.bytedance.ies.bullet.core.n
    public void n() {
        Iterator r5 = this.f6186y.iterator();     // Catch: YieldError -> L9
    L4:
        if (r5.hasNext() == false) goto L7;
        ((n) r5.next()).n();     // Catch: YieldError -> L9
    L7:
        h();
    }

    @Override // com.bytedance.ies.bullet.core.n
    public void o(Uri r10, h r11) {
        int r5 = 1;
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        boolean r12 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.core.e r13 = getBulletContext();
        Context r14 = null;
        if (r13 == null) goto L5;
        String r15 = r13.getSessionId();
    L6:
        StringBuilder r16 = new StringBuilder("kitView create kitType: ");
        if (r11 == null) goto L9;
        KitType r17 = r11.h();
    L10:
        r16.append(r17);
        com.bytedance.ies.bullet.service.base.b.b(8, r15, r16.toString(), "XView");
        this.g = r11;
        com.bytedance.ies.bullet.core.e r18 = this.d;
        if (r18 == null) goto L14;
        r18.f5298l = r11;
    L14:
        int r19 = R$id.bullet_container;
        if (this.f6167a != null) goto L17;
        this.f6167a = new LinkedHashMap();
    L17:
        View r20 = (View) this.f6167a.get(Integer.valueOf(r19));
        if (r20 != null) goto L23;
        r20 = findViewById(r19);
        if (r20 == null) goto L22;
        this.f6167a.put(Integer.valueOf(r19), r20);
        goto L23
    L22:
        r20 = null;
    L23:
        ((FrameLayout) r20).removeAllViews();
        com.bytedance.ies.bullet.core.e r21 = this.d;
        int r22 = 0;
        if (r21 == null) goto L30;
        rd.b r23 = r21.e;
        if (r23 == null) goto L30;
        Boolean r24 = (Boolean) new vd.a(r23, "enable_third_party_web_ui", Boolean.FALSE).f22372b;
        if (r24 == null) goto L30;
        boolean r25 = r24.booleanValue();
    L31:
        if (r25 == false) goto L39;
        rb.b r26 = this.f6169c;
        if (r26 == null) goto L39;
        if (r26.a(AnnieXSourceLabel.class) == null) goto L39;
        throw new ClassCastException();
    L39:
        int r27 = R$id.bullet_container;
        if (this.f6167a != null) goto L42;
        this.f6167a = new LinkedHashMap();
    L42:
        View r28 = (View) this.f6167a.get(Integer.valueOf(r27));
        if (r28 != null) goto L48;
        r28 = findViewById(r27);
        if (r28 == null) goto L47;
        this.f6167a.put(Integer.valueOf(r27), r28);
        goto L48
    L47:
        r28 = null;
    L48:
        Intrinsics.checkNotNull(r11);
        ((FrameLayout) r28).addView(r11.a());
        getContext().getResources().getConfiguration();
        com.bytedance.ies.bullet.core.e r29 = this.d;
        if (r29 == null) goto L53;
        rd.e r30 = r29.g;
        if (r30 == null) goto L53;
        com.lynx.tasm.base.a.i(r30);
    L53:
        com.bytedance.ies.bullet.service.base.b.a(6, "padAdaptation : current scenes=" + this.f.name() + ",padAdapterWidth=null,padAdapterHeight=null", null);
        com.bytedance.ies.bullet.core.e r31 = this.d;
        if (r31 == null) goto L62;
        rd.e r32 = r31.g;
        if (r32 == null) goto L62;
        Integer r33 = (Integer) new vd.b(r32.f21723a).f22372b;
        if (r33 == null) goto L62;
        int r34 = r33.intValue();
        View r35 = r11.a();
        if (r35 == null) goto L62;
        r35.setBackgroundColor(r34);
    L62:
        this.f6177o.set(true);
        Scenes r36 = this.f;
        if (r36 == Scenes.f5283c) goto L68;
        if (r36 == Scenes.f5282b) goto L68;
    L108:
        xq.b.f();
        Iterator r37 = this.f6186y.iterator();     // Catch: YieldError -> L123
    L111:
        if (r37.hasNext() == false) goto L113;
        ((n) r37.next()).o(r10, r11);     // Catch: YieldError -> L123
        goto L111
    L113:
        com.bytedance.ies.bullet.core.e r38 = this.d;     // Catch: YieldError -> L123
        if (r38 == null) goto L122;
        ArrayList r39 = r38.f5300n;     // Catch: YieldError -> L123
        if (r39 == null) goto L131;
        Iterator r40 = r39.iterator();     // Catch: YieldError -> L123
    L118:
        if (r40.hasNext() == false) goto L133;
        ((n) r40.next()).o(r10, r11);     // Catch: YieldError -> L123
        goto L118
    L133:
        return;
    L131:
        return;
    L122:
        return;
    L132:
        return;
    L68:
        if (getDecorView() == null) goto L108;
        Ref.IntRef r41 = new Ref.IntRef();
        View r42 = getDecorView();
        if (r42 == null) goto L73;
        int r43 = r42.getWidth();
    L74:
        r41.element = r43;
        Ref.IntRef r44 = new Ref.IntRef();
        View r45 = getDecorView();
        if (r45 == null) goto L77;
        int r46 = r45.getHeight();
    L78:
        r44.element = r46;
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        String r47 = r10.toString();
        ConcurrentHashMap r48 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r49 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r49 == null) goto L83;
        xc.d r50 = (xc.d) r49.a(xc.d.class);
        if (r50 == null) goto L83;
        List r51 = r50.F();
    L85:
        if (r47.length() <= 0) goto L96;
        if (r51 == null) goto L96;
        if (r51.isEmpty() == true) goto L96;
        Iterator r52 = r51.iterator();
    L92:
        if (r52.hasNext() == false) goto L96;
        if (StringsKt.g(r47, (String) r52.next()) == false) goto L92;
        boolean r53 = false;
    L97:
        this.f6180r = r53;
        ((com.bytedance.android.anniex.base.depend.c) com.bytedance.android.anniex.base.depend.a.f3114c.getValue()).getClass();
        List r54 = nb.a.f20224a;
        com.bytedance.ies.bullet.core.e r55 = this.d;
        if (r55 == null) goto L100;
        r14 = r55.f5294h;
    L100:
        Resources r56 = getContext().getResources();
        if (r56 == null) goto L105;
        Configuration r57 = r56.getConfiguration();
        if (r57 == null) goto L105;
        r22 = r57.orientation;
    L105:
        this.f6179q = nb.a.d(r22, r14);
        com.bytedance.android.anniex.container.f r58 = new com.bytedance.android.anniex.container.f(r41, r44, this, r5);
        this.f6178p = r58;
        View r59 = getDecorView();
        if (r59 == null) goto L108;
        r59.addOnLayoutChangeListener(r58);
    L96:
        r53 = true;
    L83:
        r51 = null;
        goto L85
    L77:
        r46 = 0;
        goto L78
    L73:
        r43 = 0;
    L30:
        r25 = false;
        goto L31
    L9:
        r17 = null;
        goto L10
    L5:
        r15 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.ies.bullet.core.e r5 = this.d;
        if (r5 == null) goto L11;
        com.bytedance.ies.bullet.service.monitor.b r10 = r5.f5293c;
        if (r10 == null) goto L11;
        Uri r11 = this.f6176n;
        if (r11 == null) goto L9;
        String r12 = r11.getPath();
    L10:
        r10.n(r12);
        goto L11
    L9:
        r12 = null;
    L11:
        com.bytedance.ies.bullet.core.e r13 = this.d;
        if (r13 == null) goto L17;
        com.bytedance.ies.bullet.service.monitor.b r14 = r13.f5293c;
        if (r14 == null) goto L17;
        r14.g(this);
    L17:
        if (this.d == null) goto L19;
        Lazy r15 = com.bytedance.ies.bullet.core.f.f5312b;
        com.bytedance.ies.bullet.core.f r16 = td.b.b();
        com.bytedance.ies.bullet.core.e r17 = this.d;
        Intrinsics.checkNotNull(r17);
        r16.c(r17);
        LinkedHashMap r18 = cd.a.f1171a;
        cd.a.b(getSessionId(), this.f6169c);
    L19:
        com.bytedance.ies.bullet.core.container.c r19 = getActivityWrapper();
        if (r19 == null) goto L24;
        sj.e r20 = this.B;
        Intrinsics.checkNotNullParameter(r20, "delegate");
        ArrayList r21 = ((com.bytedance.ies.bullet.core.container.a) r19).f5287a;
        if (r21.contains(r20) == true) goto L24;
        r21.add(r20);
    L24:
        com.bytedance.ies.bullet.core.d r22 = com.bytedance.ies.bullet.core.d.f5288b;
        String r23 = getBid();
        r22.getClass();
        Intrinsics.checkNotNullParameter(this, "bulletContainer");
        if (r23 == null) goto L33;
        LinkedHashMap r24 = r22.f5289a;
        if (((Map) r24.get(r23)) != null) goto L29;
        r24.put(r23, new LinkedHashMap());
    L29:
        Map r25 = (Map) r24.get(r23);
        if (r25 == null) goto L34;
        r25.put(String.valueOf(hashCode()), this);
        return;
    L34:
        return;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        if (r10 != null) goto L6;
        return;
    L6:
        if (getActivityWrapper() != null) goto L13;
        com.bytedance.ies.bullet.core.e r5 = this.d;
        if (r5 == null) goto L13;
        rd.e r11 = r5.g;
        if (r11 == null) goto L13;
        com.lynx.tasm.base.a.i(r11);
    L13:
        if (this.f6180r == true) goto L15;
        d(r10.orientation, null);
    L15:
        Lazy r12 = com.bytedance.android.anniex.base.depend.a.f3114c;
        ((com.bytedance.android.anniex.base.depend.c) r12.getValue()).getClass();
        ((com.bytedance.android.anniex.base.depend.c) r12.getValue()).getClass();
        com.bytedance.ies.bullet.core.e r13 = this.d;
        if (r13 != null) goto L18;
    L20:
        h r14 = getKitView();
        if (r14 != null) goto L23;
        return;
    L23:
        if ((r14 instanceof vc.d) == false) goto L25;
        vc.d r15 = (vc.d) r14;
    L26:
        if (r15 == null) goto L52;
        com.bytedance.ies.bullet.core.e r16 = this.d;
        if (r16 == null) goto L32;
        rd.e r17 = r16.g;
        if (r17 == null) goto L32;
        com.lynx.tasm.base.a.i(r17);
        Boolean r18 = Boolean.FALSE;
    L33:
        Intrinsics.areEqual(r18, Boolean.TRUE);
        xd.d r19 = v0.p(getContext());
        if (r19 == null) goto L53;
        com.bytedance.ies.bullet.lynx.h r20 = (com.bytedance.ies.bullet.lynx.h) r15;
        int r21 = r19.f23106b;
        int r22 = r19.f23105a;
        if (r22 <= 0) goto L49;
        if (r21 <= 0) goto L49;
        if (r20.f5640i == null) goto L41;
        int r23 = (int) (r22 * 1.0f);
        int r24 = (int) (r21 * 1.0f);
    L42:
        LynxView r25 = r20.g;
        if (r25 == null) goto L45;
        r25.updateScreenMetrics(r23, r24);
    L45:
        LynxView r26 = r20.g;
        if (r26 == null) goto L48;
        r26.requestLayout();
    L48:
        boolean r27 = com.bytedance.ies.bullet.service.base.b.f5956a;
        StringBuilder r28 = j0.v("updateScreenMetrics w:", r23, r24, " h:", " view:");
        r28.append(r20.g);
        com.bytedance.ies.bullet.service.base.b.d(r28.toString(), LogLevel.f5954b, "XLynxKit");
        goto L49
    L41:
        r23 = r22;
        r24 = r21;
    L49:
        boolean r29 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(6, "BulletCardView updateLynxScreenMetrics : enableIpadAdapter " + r18 + " , width " + r22 + " , height " + r21, null);
        return;
    L53:
        return;
    L32:
        r18 = null;
        goto L33
    L52:
        return;
    L25:
        r15 = null;
        goto L26
    L18:
        if (r13.D != true) goto L20;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.ies.bullet.core.e r5 = this.d;
        if (r5 == null) goto L7;
        com.bytedance.ies.bullet.service.monitor.b r10 = r5.f5293c;
        if (r10 == null) goto L7;
        r10.r();
    L7:
        com.bytedance.ies.bullet.core.container.c r11 = getActivityWrapper();
        if (r11 == null) goto L10;
        sj.e r12 = this.B;
        Intrinsics.checkNotNullParameter(r12, "delegate");
        ((com.bytedance.ies.bullet.core.container.a) r11).f5287a.remove(r12);
    L10:
        com.bytedance.ies.bullet.core.d.f5288b.a(getBid(), this);
        if (this.f6181t == false) goto L13;
        release();
    L13:
        g();
    }

    @Override // com.bytedance.ies.bullet.core.n
    public void p(Uri r10, h r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        Lazy r5 = com.bytedance.android.anniex.base.depend.a.f3114c;
        ((com.bytedance.android.anniex.base.depend.c) r5.getValue()).getClass();
        ((com.bytedance.android.anniex.base.depend.c) r5.getValue()).getClass();
        Iterator r12 = this.f6186y.iterator();     // Catch: YieldError -> L80
    L5:
        if (r12.hasNext() == false) goto L7;
        ((n) r12.next()).p(r10, r11);     // Catch: YieldError -> L80
        goto L5
    L7:
        com.bytedance.ies.bullet.core.e r13 = this.d;     // Catch: YieldError -> L80
        if (r13 == null) goto L16;
        ArrayList r14 = r13.f5300n;     // Catch: YieldError -> L80
        if (r14 == null) goto L16;
        Iterator r15 = r14.iterator();     // Catch: YieldError -> L80
    L12:
        if (r15.hasNext() == false) goto L16;
        ((n) r15.next()).p(r10, r11);     // Catch: YieldError -> L80
    L16:
        this.f6182u.getAndSet(2);
        ConcurrentHashMap r16 = mb.a.f20054a;
        mb.b r17 = mb.a.a(getBid());
        String r18 = null;
        if (com.bytedance.ies.bullet.core.h.g.f5315a == true) goto L19;
    L21:
        r17 = null;
    L22:
        if (r17 == null) goto L72;
        int r19 = getChildCount();
        int r20 = 1;
        DebugTagTextView r21 = null;
    L24:
        if (r20 >= r19) goto L34;
        View r22 = getChildAt(r20);
        if (r22 != null) goto L28;
    L31:
        if (r21 != null) goto L34;
        r20 = r20 + 1;
        goto L24
    L28:
        if ((r22 instanceof DebugTagTextView) == false) goto L30;
        r21 = (DebugTagTextView) r22;
        goto L31
    L30:
        r21 = null;
    L34:
        if (r21 != null) goto L40;
        View r23 = LayoutInflater.from(getContext()).inflate(R$layout.bullet_debug_tag_view, null);
        if ((r23 instanceof DebugTagTextView) == false) goto L38;
        r21 = (DebugTagTextView) r23;
    L39:
        FrameLayout.LayoutParams r24 = new FrameLayout.LayoutParams(-2, -2);
        r24.gravity = 8388691;
        int r25 = getResources().getDimensionPixelSize(R$dimen.bullet_debug_tab_view_margin);
        r24.leftMargin = r25;
        r24.bottomMargin = r25;
        addView(r21, r24);
        goto L40
    L38:
        r21 = null;
    L40:
        if (r21 == null) goto L72;
        com.bytedance.ies.bullet.core.e r26 = this.d;
        if (r26 == null) goto L46;
        Scenes r27 = r26.f5295i;
        if (r27 == null) goto L46;
        String r28 = r27.f5286a;
    L47:
        String r29 = r17.f20056b;
        String r30 = "";
        if (r29 != null) goto L50;
    L53:
        String r110 = "";
    L54:
        com.bytedance.ies.bullet.core.e r31 = this.d;
        if (r31 == null) goto L59;
        com.bytedance.ies.bullet.core.c r32 = r31.f5308w;
        if (r32 == null) goto L59;
        CacheType r33 = r32.e;
    L60:
        if (r33 == null) goto L68;
        int r34 = r33.ordinal();
        if (r34 == 0) goto L67;
        if (r34 != 1) goto L68;
        r30 = "(ReUse)";
        goto L68
    L67:
        r30 = "(PreRender)";
    L68:
        StringBuilder r35 = new StringBuilder();
        r35.append(r28);
        r35.append('_');
        r35.append(r110);
        h r111 = this.g;
        if (r111 == null) goto L71;
        r18 = r111.f();
    L71:
        r35.append(r18);
        r35.append(r30);
        r21.setText(r35.toString());
        com.bytedance.ies.bullet.core.h.g.getClass();
    L59:
        r33 = null;
        goto L60
    L50:
        if (r29.length() == 0) goto L53;
        r110 = j0.q(new StringBuilder(), r17.f20056b, " - ");
    L46:
        r28 = null;
    L72:
        CopyOnWriteArrayList r112 = i.f5318a;
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(this, "view");
        CopyOnWriteArrayList r36 = i.f5318a;
        if (r36.size() <= 0) goto L79;
        Iterator r37 = r36.iterator();
        if (r37.hasNext() == true) goto L78;
        return;
    L78:
        throw mn.h.c(r37);
    L79:
        return;
    L19:
        if (r17.f20055a == false) goto L21;
        goto L21
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void q(Uri r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "e");
        Iterator r11 = this.f6186y.iterator();     // Catch: YieldError -> L17
    L5:
        if (r11.hasNext() == false) goto L7;
        ((n) r11.next()).q(r5, r10);     // Catch: YieldError -> L17
        goto L5
    L7:
        com.bytedance.ies.bullet.core.e r12 = this.d;     // Catch: YieldError -> L17
        if (r12 == null) goto L16;
        ArrayList r13 = r12.f5300n;     // Catch: YieldError -> L17
        if (r13 == null) goto L22;
        Iterator r14 = r13.iterator();     // Catch: YieldError -> L17
    L12:
        if (r14.hasNext() == false) goto L24;
        ((n) r14.next()).q(r5, r10);     // Catch: YieldError -> L17
        goto L12
    L24:
        return;
    L22:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public void r(Uri r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "e");
        Iterator r11 = this.f6186y.iterator();     // Catch: YieldError -> L24
    L5:
        if (r11.hasNext() == false) goto L7;
        ((n) r11.next()).r(r5, r10);     // Catch: YieldError -> L24
        goto L5
    L7:
        com.bytedance.ies.bullet.core.e r12 = this.d;     // Catch: YieldError -> L24
        if (r12 == null) goto L16;
        ArrayList r13 = r12.f5300n;     // Catch: YieldError -> L24
        if (r13 == null) goto L16;
        Iterator r14 = r13.iterator();     // Catch: YieldError -> L24
    L12:
        if (r14.hasNext() == false) goto L16;
        ((n) r14.next()).r(r5, r10);     // Catch: YieldError -> L24
    L16:
        this.f6182u.getAndSet(3);
        h();
        CopyOnWriteArrayList r15 = i.f5318a;
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(this, "view");
        CopyOnWriteArrayList r16 = i.f5318a;
        if (r16.size() <= 0) goto L23;
        Iterator r17 = r16.iterator();
        if (r17.hasNext() == true) goto L22;
        return;
    L22:
        throw mn.h.c(r17);
    }

    @Override // com.bytedance.ies.bullet.service.base.m
    public final void release() {
        LinkedHashMap r5 = cd.a.f1171a;
        com.bytedance.ies.bullet.core.e r10 = this.d;
        if (r10 == null) goto L5;
        String r11 = r10.getSessionId();
    L6:
        cd.a.a(r11).c(com.bytedance.ies.bullet.core.container.c.class);
        n();
        h r12 = this.g;
        if (r12 == null) goto L9;
        r12.destroy();
    L9:
        this.g = null;
        ConcurrentHashMap r13 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r14 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r14 == null) goto L14;
        xc.d r15 = (xc.d) r14.a(xc.d.class);
        if (r15 == null) goto L14;
        boolean r16 = r15.u();
    L15:
        if (r16 == false) goto L19;
        com.bytedance.ies.bullet.core.e r17 = this.d;
        if (r17 == null) goto L23;
        r17.release();
    L23:
        com.bytedance.android.anniex.container.f r18 = this.f6178p;
        if (r18 == null) goto L29;
        View r19 = getDecorView();
        if (r19 == null) goto L28;
        r19.removeOnLayoutChangeListener(r18);
    L28:
        this.f6178p = null;
    L29:
        com.bytedance.ies.bullet.core.d.f5288b.a(getBid(), this);
        com.bytedance.ies.bullet.core.e r20 = this.d;
        if (r20 == null) goto L32;
        com.bytedance.ies.bullet.core.c r21 = r20.f5308w;
    L33:
        if (r21 == null) goto L36;
        r21.f5280k = true;
    L36:
        tc.c r22 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r23 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r23 == null) goto L40;
        com.bytedance.ies.bullet.service.base.d r24 = (com.bytedance.ies.bullet.service.base.d) r23.f6163b.getValue();
    L40:
        if (this.d == null) goto L46;
        getProviderFactory().f21717a.clear();
        com.bytedance.ies.bullet.core.e r25 = this.d;
        if (r25 == null) goto L44;
        String r26 = r25.getSessionId();
    L45:
        cd.a.a(r26).f21717a.clear();
        goto L46
    L44:
        r26 = null;
    L46:
        g();
        com.bytedance.ies.bullet.core.e r27 = this.d;
        if (r27 == null) goto L51;
        String r28 = r27.getSessionId();
        if (r28 == null) goto L51;
        Intrinsics.checkNotNullParameter(r28, "sessionId");
        c4.a.f1115a.b(r28);
    L51:
        this.f6187z.d = null;
        return;
    L32:
        r21 = null;
        goto L33
    L19:
        com.bytedance.ies.bullet.core.e r29 = this.d;
        if (r29 == null) goto L23;
        r29.f5294h = null;
    L14:
        r16 = true;
        goto L15
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void s(Uri r10, hb.a r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.core.e r12 = this.d;
        if (r12 == null) goto L7;
        rd.b r13 = r12.e;
        if (r13 == null) goto L7;
        Uri r14 = ((com.bytedance.ies.bullet.service.sdk.b) r13).f6135c;
    L8:
        Map r15 = MapsKt.mapOf(TuplesKt.to("url", String.valueOf(r14)));
        com.bytedance.ies.bullet.base.utils.logger.b r16 = new com.bytedance.ies.bullet.base.utils.logger.b();
        com.bytedance.ies.bullet.core.e r17 = this.d;
        if (r17 == null) goto L12;
        String r18 = r17.getSessionId();
        if (r18 == null) goto L12;
    L13:
        Intrinsics.checkNotNullParameter("session_id", "name");
        Intrinsics.checkNotNullParameter(r18, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("session_id", r18, r16.f5260a);
        Unit r19 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter("XView", "moduleTag");
        Intrinsics.checkNotNullParameter("tridentMsg onKitViewDestroy", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XView", "tridentMsg onKitViewDestroy", r15, r16);
        Iterator r20 = this.f6186y.iterator();     // Catch: YieldError -> L29
    L16:
        if (r20.hasNext() == false) goto L18;
        ((n) r20.next()).s(r10, r11);     // Catch: YieldError -> L29
        goto L16
    L18:
        com.bytedance.ies.bullet.core.e r21 = this.d;     // Catch: YieldError -> L29
        if (r21 == null) goto L27;
        ArrayList r22 = r21.f5300n;     // Catch: YieldError -> L29
        if (r22 == null) goto L27;
        Iterator r23 = r22.iterator();     // Catch: YieldError -> L29
    L23:
        if (r23.hasNext() == false) goto L27;
        ((n) r23.next()).s(r10, r11);     // Catch: YieldError -> L29
    L27:
        this.f6184w.getAndSet(false);
        return;
    L12:
        r18 = "";
    L7:
        r14 = null;
        goto L8
    }

    public void setActivityWrapper(com.bytedance.ies.bullet.core.container.c r5) {
        LinkedHashMap r10 = cd.a.f1171a;
        com.bytedance.ies.bullet.core.e r11 = this.d;
        if (r11 == null) goto L5;
        String r12 = r11.getSessionId();
    L6:
        rb.b r13 = cd.a.a(r12);
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.core.container.c.class, "clazz");
        r13.b(com.bytedance.ies.bullet.core.container.c.class, new rb.a(r5, 0));
        sj.e r14 = this.B;
        if (r5 == null) goto L9;
        Intrinsics.checkNotNullParameter(r14, "delegate");
        ((com.bytedance.ies.bullet.core.container.a) r5).f5287a.remove(r14);
    L9:
        if (r5 == null) goto L13;
        Intrinsics.checkNotNullParameter(r14, "delegate");
        ArrayList r15 = ((com.bytedance.ies.bullet.core.container.a) r5).f5287a;
        if (r15.contains(r14) == true) goto L13;
        r15.add(r14);
    L13:
        this.A = r5;
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void setAutoReleasableWhenDetached(boolean r5) {
        this.f6181t = r5;
    }

    public final void setEventInterceptor(wd.a r5) {
        this.C = r5;
    }

    public void setLynxClient(vc.c r5) {
        this.f6175m = r5;
    }

    public final void setMCurrentScene(Scenes r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f = r5;
    }

    @Deprecated(message = "unused, to be deleted")
    public final void setSessionId(String r5) {
        Intrinsics.checkNotNullParameter(r5, "id");
        com.bytedance.ies.bullet.core.e r10 = this.d;
        if (r10 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r10.f5291a = r5;
    }

    public final void setUri(Uri r5) {
        this.f6176n = r5;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public void u(Uri r5, com.bytedance.ies.bullet.core.container.e r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.core.e r12 = this.d;
        if (r12 == null) goto L7;
        rd.b r13 = r12.e;
        if (r13 == null) goto L7;
        Uri r14 = ((com.bytedance.ies.bullet.service.sdk.b) r13).f6135c;
    L8:
        Map r15 = MapsKt.mapOf(TuplesKt.to("url", String.valueOf(r14)));
        com.bytedance.ies.bullet.base.utils.logger.b r16 = new com.bytedance.ies.bullet.base.utils.logger.b();
        com.bytedance.ies.bullet.core.e r17 = this.d;
        if (r17 == null) goto L12;
        String r18 = r17.getSessionId();
        if (r18 == null) goto L12;
    L13:
        Intrinsics.checkNotNullParameter("session_id", "name");
        Intrinsics.checkNotNullParameter(r18, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("session_id", r18, r16.f5260a);
        Unit r19 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter("XView", "moduleTag");
        Intrinsics.checkNotNullParameter("tridentMsg onLoadStart", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XView", "tridentMsg onLoadStart", r15, r16);
        Iterator r20 = this.f6186y.iterator();     // Catch: YieldError -> L20
    L16:
        if (r20.hasNext() == false) goto L25;
        n r21 = (n) r20.next();     // Catch: YieldError -> L20
        Uri r22 = this.f6176n;     // Catch: YieldError -> L20
        Intrinsics.checkNotNull(r22);     // Catch: YieldError -> L20
        r21.u(r22, this);     // Catch: YieldError -> L20
    L25:
        return;
    L19:
        return;
    L12:
        r18 = "";
    L7:
        r14 = null;
        goto L8
    }

    @Override // com.bytedance.ies.bullet.core.n
    public void v(Uri r5, h r10, rd.e r11) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "schemaModelUnion");
        Iterator r12 = this.f6186y.iterator();     // Catch: YieldError -> L17
    L5:
        if (r12.hasNext() == false) goto L7;
        ((n) r12.next()).v(r5, r10, r11);     // Catch: YieldError -> L17
        goto L5
    L7:
        com.bytedance.ies.bullet.core.e r13 = this.d;     // Catch: YieldError -> L17
        if (r13 == null) goto L16;
        ArrayList r14 = r13.f5300n;     // Catch: YieldError -> L17
        if (r14 == null) goto L22;
        Iterator r15 = r14.iterator();     // Catch: YieldError -> L17
    L12:
        if (r15.hasNext() == false) goto L24;
        ((n) r15.next()).v(r5, r10, r11);     // Catch: YieldError -> L17
        goto L12
    L24:
        return;
    L22:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void w(Uri r5, h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Iterator r11 = this.f6186y.iterator();     // Catch: YieldError -> L24
    L5:
        if (r11.hasNext() == false) goto L7;
        ((n) r11.next()).w(r5, r10);     // Catch: YieldError -> L24
        goto L5
    L7:
        com.bytedance.ies.bullet.core.e r12 = this.d;     // Catch: YieldError -> L24
        if (r12 == null) goto L16;
        ArrayList r13 = r12.f5300n;     // Catch: YieldError -> L24
        if (r13 == null) goto L16;
        Iterator r14 = r13.iterator();     // Catch: YieldError -> L24
    L12:
        if (r14.hasNext() == false) goto L16;
        ((n) r14.next()).w(r5, r10);     // Catch: YieldError -> L24
    L16:
        this.f6184w.getAndSet(true);
        if (this.f6183v.get() == false) goto L29;
        boolean r15 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.core.e r16 = getBulletContext();
        if (r16 == null) goto L21;
        String r17 = r16.getSessionId();
    L22:
        com.bytedance.ies.bullet.service.base.b.h("BulletCardView.onRuntimeReady: call onEnterForeground", null, "XPopup", r17, 98);
        d();
        return;
    L21:
        r17 = null;
        goto L22
    }

    @JvmOverloads
    public BulletCardView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void b() {
        Iterator r5 = this.f6186y.iterator();     // Catch: YieldError -> L15
    L4:
        if (r5.hasNext() == false) goto L7;
        ((n) r5.next()).b();     // Catch: YieldError -> L15
    L7:
        boolean r10 = com.bytedance.ies.bullet.service.base.b.f5956a;
        Lazy r11 = com.bytedance.android.anniex.base.depend.a.f3113b;
        ((com.bytedance.android.anniex.base.depend.b) r11.getValue()).getClass();
        ((com.bytedance.android.anniex.base.depend.b) r11.getValue()).getClass();
        com.bytedance.ies.bullet.core.e r12 = this.d;
        if (r12 == null) goto L10;
        String r13 = r12.getSessionId();
    L11:
        com.bytedance.ies.bullet.service.base.b.h("onUserCaptureScreen addScreenCaptureListener， isBaseMode：falseisPrivacyDialogShow：false", null, null, r13, 110);
        ((com.bytedance.android.anniex.base.depend.b) r11.getValue()).getClass();
        ((com.bytedance.android.anniex.base.depend.b) r11.getValue()).getClass();
        if (this.f6173k != null) goto L20;
        this.f6173k = new b(this);
        h.f.b(new m(this, 8), h.f.g);
        return;
    L20:
        return;
    L10:
        r13 = null;
        goto L11
    }

    public /* synthetic */ BulletCardView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public BulletCardView(final Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f6167a = new LinkedHashMap();
        if (D == true) goto L9;
        D = true;
        com.bytedance.ies.bullet.base.b.a(r5);     // Catch: Throwable -> L7
        com.bytedance.ies.bullet.service.base.b.a(2, "BulletCardView call BulletSdk.ensureDefaultBidReady success", "XView");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        boolean r12 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "BulletCardView call BulletSdk.ensureDefaultBidReady failed, message = " + th.getMessage(), "XView");
    L9:
        rb.b r13 = new rb.b();
        Intrinsics.checkNotNullParameter(Context.class, "clazz");
        r13.b(Context.class, new rb.a(r5, 0));
        this.f6168b = r13;
        this.e = System.currentTimeMillis();
        this.f = Scenes.f;
        this.f6170h = "default_bid";
        this.f6171i = new ArrayList();
        this.f6172j = Orientation.f6193a;
        this.f6174l = "onUserCaptureScreen";
        this.f6175m = new c(this);
        this.f6177o = new AtomicBoolean(false);
        this.s = LazyKt.lazy(new BulletCardView$decorView$2(r5));
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L12
        addView(new lb.a(r5));     // Catch: Throwable -> L12
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        this.f6182u = new AtomicInteger(0);
        this.f6183v = new AtomicBoolean(false);
        this.f6184w = new AtomicBoolean(false);
        this.f6185x = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new BulletCardView$serviceContext$2(r5));
        this.f6186y = new ConcurrentLinkedQueue();
        this.f6187z = new com.bytedance.ies.bullet.ui.common.loader.c(getServiceContext(), this.f6170h);
        this.B = new sj.e();
        return;
    L12:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public final void f(String r5) {
        Intrinsics.checkNotNullParameter(r5, "bid");
        this.f6170h = r5;
        com.bytedance.ies.bullet.core.e r10 = this.d;
        if (r10 == null) goto L6;
        r10.f = r5;
    L6:
        com.bytedance.ies.bullet.ui.common.loader.c r11 = this.f6187z;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r5, "bid");
        r11.f6212c = r5;
        mb.a.a(r5);
    }

    public final void d(int r10, LinkedHashMap r11) {
        Orientation[] r5 = Orientation.values();
        int r12 = r5.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        Orientation r14 = r5[r13];
        if (r14.ordinal() == r10) goto L9;
        r13 = r13 + 1;
    L9:
        if (r14 != null) goto L12;
        r14 = Orientation.f6193a;
    L12:
        if (r14 == this.f6172j) goto L20;
        com.bytedance.android.anniex.container.g r15 = new com.bytedance.android.anniex.container.g(r11, r14, this);
        Intrinsics.checkNotNullParameter(r15, "event");
        h r16 = this.g;
        if (r16 == null) goto L16;
        r16.a("screenOrientationChange", (JSONObject) r15.f3144b);
    L16:
        this.f6172j = r14;
        return;
    L20:
        return;
    L8:
        r14 = null;
        goto L9
    }

    public final void e(Uri r10, Bundle r11, rb.b r12) {
        com.bytedance.ies.bullet.core.e r5 = this.d;
        if (r5 == null) goto L6;
        Scenes r13 = this.f;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r5.f5295i = r13;
    L6:
        com.bytedance.ies.bullet.core.e r14 = this.d;
        boolean r15 = true;
        if (r14 == null) goto L16;
        int r16 = this.f.ordinal();
        if (r16 == 0) goto L14;
        if (r16 == 1) goto L13;
        Components r17 = Components.e;
    L15:
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r14.f5296j = r17;
        goto L16
    L13:
        r17 = Components.d;
        goto L15
    L14:
        r17 = Components.f5183b;
    L16:
        u(r10, this);
        if (r12 != null) goto L19;
        r12 = new rb.b();
    L19:
        rb.b r18 = getProviderFactory();
        Intrinsics.checkNotNullParameter(r18, "other");
        r12.f21717a.putAll(r18.f21717a);
        com.bytedance.ies.bullet.core.e r19 = this.d;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.core.e.class, "clazz");
        r12.b(com.bytedance.ies.bullet.core.e.class, new rb.a(r19));
        this.f6169c = r12;
        LinkedHashMap r20 = cd.a.f1171a;
        com.bytedance.ies.bullet.core.e r21 = this.d;
        if (r21 == null) goto L22;
        String r22 = r21.getSessionId();
    L23:
        cd.a.b(r22, this.f6169c);
        ((rc.a) getServiceContext()).b(com.bytedance.ies.bullet.core.e.class, this.d);
        com.bytedance.ies.bullet.core.e r23 = this.d;
        if (r23 == null) goto L35;
        r23.f5294h = getContext();
        r23.f5297k = r10;
        r23.f5305t.f287b = r11;
        r23.f5299m = this;
        wc.a r24 = (wc.a) r12.a(wc.a.class);
        if (r24 == null) goto L28;
        r23.f5309x.f5346a = r24;
    L28:
        CacheType r25 = (CacheType) r12.a(CacheType.class);
        if (r25 == null) goto L31;
        r23.f5308w.e = r25;
    L31:
        ae.a r26 = (ae.a) r12.a(ae.a.class);
        if (r26 == null) goto L34;
        r23.f5306u.f5321c = r26;
    L34:
        r23.f5304r = getServiceContext();
    L35:
        if (r11 == null) goto L37;
        Intrinsics.checkNotNullParameter(Bundle.class, "clazz");
        r12.b(Bundle.class, new rb.a(r11, 0));
    L37:
        Context r27 = getContext();
        Intrinsics.checkNotNullParameter(Context.class, "clazz");
        r12.b(Context.class, new rb.a(r27, 0));
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.core.container.e.class, "clazz");
        r12.b(com.bytedance.ies.bullet.core.container.e.class, new rb.a(this, 0));
        com.bytedance.ies.bullet.core.container.c r28 = getActivityWrapper();
        if (r28 == null) goto L40;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.core.container.c.class, "clazz");
        r12.b(com.bytedance.ies.bullet.core.container.c.class, new rb.a(r28, 0));
    L40:
        this.f6182u.getAndSet(1);
        this.f6171i.clear();
        Intrinsics.checkNotNullParameter(Uri.class, "clazz");
        r12.b(Uri.class, new rb.a(r10, 0));
        Intrinsics.checkNotNullParameter(BulletCardView.class, "clazz");
        r12.b(BulletCardView.class, new rb.a(this));
        this.C = (wd.a) r12.a(wd.a.class);
        com.bytedance.ies.bullet.core.e r110 = this.d;
        if (r110 == null) goto L45;
        com.bytedance.ies.bullet.service.monitor.b r111 = r110.f5293c;
        if (r111 == null) goto L45;
        r111.s();
    L45:
        ((rc.a) getServiceContext()).b(com.bytedance.ies.bullet.core.e.class, this.d);
        AtomicBoolean r112 = this.f6177o;
        boolean r29 = r112.get();
        com.bytedance.ies.bullet.ui.common.loader.c r30 = this.f6187z;
        if (r29 == true) goto L48;
        boolean r113 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "kit view has been removed: " + this.f6176n, "XView");
    L90:
        com.bytedance.ies.bullet.core.e r114 = this.d;
        Intrinsics.checkNotNull(r114);
        r30.g(r114, r10, r11, this);
        return;
    L48:
        boolean r31 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "remove kit view: " + this.f6176n, "XView");
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L52
        h r33 = this.g;     // Catch: Throwable -> L52
        if (r33 == null) goto L54;
        r33.destroy();     // Catch: Throwable -> L52
    L54:
        h r34 = this.g;     // Catch: Throwable -> L52
        if (r34 == null) goto L64;
        View r35 = r34.a();     // Catch: Throwable -> L52
        if (r35 == null) goto L64;
        ViewParent r36 = r35.getParent();     // Catch: Throwable -> L52
        if ((r36 instanceof ViewGroup) == false) goto L61;
        ViewGroup r37 = (ViewGroup) r36;     // Catch: Throwable -> L52
    L62:
        if (r37 == null) goto L64;
        r37.removeView(r35);     // Catch: Throwable -> L52
        Unit r38 = Unit.INSTANCE;     // Catch: Throwable -> L52
    L65:
        Object r39 = Result.m124constructorimpl(r38);     // Catch: Throwable -> L52
    L68:
        Throwable r40 = Result.m127exceptionOrNullimpl(r39);
        if (r40 == null) goto L71;
        boolean r41 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.g("remove kit view for " + this.f6176n + " failed.", "XView", r40);
    L71:
        this.g = null;
        r30.d = null;
        ConcurrentHashMap r42 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r43 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r43 == null) goto L78;
        xc.d r44 = (xc.d) r43.a(xc.d.class);
        if (r44 == null) goto L78;
        Boolean r45 = r44.h();
        if (r45 == null) goto L78;
        r15 = r45.booleanValue();
    L78:
        if (r15 == false) goto L89;
        com.bytedance.ies.bullet.core.e r46 = this.d;
        if (r46 == null) goto L83;
        r46.f5298l = null;
    L83:
        if (r46 == null) goto L86;
        r46.f5301o = null;
    L86:
        if (r46 == null) goto L89;
        r46.f5302p = null;
    L89:
        r112.set(false);
        goto L90
    L61:
        r37 = null;
    L64:
        r38 = null;
    L52:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        r39 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L68
    L22:
        r22 = null;
        goto L23
    }
}

package com.bytedance.android.livesdk.feed.live;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.FormatUtils;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.config.uj;
import com.bytedance.android.livesdk.feed.f;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdk.feed.h;
import com.bytedance.android.livesdk.feed.j;
import com.bytedance.android.livesdk.feed.z0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.p1;
import com.bytedance.android.livesdkapi.depend.model.live.LiveHashTagInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListDataSource;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.StringUtils;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kw1.c;
import org.json.JSONObject;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class CommonLiveViewHolder extends BaseLiveViewHolder {
    public static final /* synthetic */ int C = 0;
    public final TextView A;
    public z0 B;
    public final TextView r;
    public final HSImageView s;
    public final HSImageView t;
    public final ImageView u;
    public final TextView v;
    public final View w;
    public final TextView x;
    public final ImageView y;
    public final View z;

    public class a extends q0 {
        public final /* synthetic */ CommonLiveViewHolder a;

        public a(CommonLiveViewHolder r1) {
            this.a = r1;
        }

        public final void h(k r1, int r2, int r3) {
            ViewGroup.LayoutParams r4 = this.a.t.getLayoutParams();
            r4.width = (int) (r4.height * (r2 / r3));
            this.a.t.setLayoutParams(r4);
        }
    }

    public class b extends q0 {
        public final /* synthetic */ long[] a;
        public final /* synthetic */ Room b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ImageModel d;
        public final /* synthetic */ CommonLiveViewHolder e;

        public final void g(k r4) {
            this.a[0] = SystemClock.currentThreadTimeMillis();
            HashMap r5 = new HashMap();
            r5.put("enter_from_merge", "live_merge");
            r5.put("enter_method", "live_cover");
            r5.put("anchor_id", this.b.getOwnerUserIdString());
            r5.put("request_id", this.b.getRequestId());
            r5.put("room_id", String.valueOf(this.b.getId()));
            r5.put("event_belong", "live_view");
            r5.put("event_page", "live");
            r5.put("event_type", "core");
            r5.put("event_module", this.c);
            this.e.getClass();
            r5.put("request_page", "");
            c.d("live_cover_show_start", r5);
            z0 r6 = this.e.B;
            r6.getClass();
            r6.c = SystemClock.uptimeMillis();
        }

        public final void f(k r7, Exception r8) {
            HashMap r0 = new HashMap();
            r0.put("enter_from_merge", "live_merge");
            r0.put("enter_method", "live_cover");
            r0.put("anchor_id", this.b.getOwnerUserIdString());
            r0.put("request_id", this.b.getRequestId());
            r0.put("room_id", String.valueOf(this.b.getId()));
            r0.put("is_success", "0");
            r0.put("time", String.valueOf(SystemClock.currentThreadTimeMillis() - this.a[0]));
            r0.put("event_belong", "live_view");
            r0.put("event_page", "live");
            r0.put("event_type", "core");
            r0.put("event_module", this.c);
            this.e.getClass();
            r0.put("request_page", "");
            c.d("live_cover_show_finish", r0);
            this.e.B.o(r8, r7.getUri());
            this.e.s.setImageResource(2131250288);
            this.e.d4(this.d);
        }

        public final void h(k r10, int r11, int r12) {
            HashMap r13 = new HashMap();
            r13.put("enter_from_merge", "live_merge");
            r13.put("enter_method", "live_cover");
            r13.put("anchor_id", this.b.getOwnerUserIdString());
            r13.put("request_id", this.b.getRequestId());
            r13.put("room_id", String.valueOf(this.b.getId()));
            r13.put("is_success", "1");
            r13.put("time", String.valueOf(SystemClock.currentThreadTimeMillis() - this.a[0]));
            r13.put("event_belong", "live_view");
            r13.put("event_page", "live");
            r13.put("event_type", "core");
            r13.put("event_module", this.c);
            this.e.getClass();
            String r0 = "";
            r13.put("request_page", "");
            c.d("live_cover_show_finish", r13);
            z0 r14 = this.e.B;
            if (r10 == null) goto L7;
            r0 = r10.getUri();
        L7:
            if (r14.c <= 0) goto L9;
            long r3 = SystemClock.uptimeMillis() - r14.c;
        L10:
            r14.c = 0;
            JSONObject r15 = new JSONObject();
            BaseMonitor.add(r15, "url", r0);
            LiveSlardarMonitor.monitorStatusAndDuration("ttlive_feed_image_load_all", 0, r3, r15);
            long r16 = kw1.a.a;
            if (r16 > kw1.a.b) goto L13;
            return;
        L13:
            if (kw1.a.d > 0) goto L15;
            return;
        L15:
            if (kw1.a.c == true) goto L24;
            kw1.a.b = r16;
            long r17 = SystemClock.elapsedRealtime() - kw1.a.d;
            LinkedHashMap r18 = new LinkedHashMap();
            if (r17 <= 0) goto L19;
            String r19 = String.valueOf(r17);
        L20:
            r18.put("duration", r19);
            c.d("livesdk_cover_load_duration", r18);
            return;
        L19:
            r19 = String.valueOf(0);
            goto L20
        L24:
            return;
        L9:
            r3 = 0;
            goto L10
        }

        public b(CommonLiveViewHolder r1, long[] r2, Room r3, String r4, ImageModel r5) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public abstract void c4(FeedItem r1);

    public void d4(ImageModel r1) {
    }

    public final boolean b4() {
        uj r0 = uj.a;
        if (r0.getValue() != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getValue().showChallenge == false) goto L7;
        return true;
    }

    public void a4(ImageModel r9, Room r10) {
        long[] r3 = new long[1];
        e r1 = this.h;
        if (r1 == null) goto L5;
        String r2 = r1.e();
    L6:
        String r5 = r2;
        this.B = new z0();
        ImageLoader.d r7 = ImageLoader.load(r9);
        r7.g = true;
        r7.f = false;
        r7.e = new b(this, r3, r10, r5, r9);
        r7.a(this.s);
        return;
    L5:
        r2 = "live_live";
        goto L6
    }

    public final void e4(View r1, int r2) {
        if (r1 == null) goto L5;
        r1.setVisibility(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public void U3(final FeedItem r13, final Room r14, int r15) {
        e4(this.z, 0);
        e4(this.w, 8);
        this.y.setVisibility(8);
        if (this.u != null) goto L5;
    L9:
        IUser r16 = r14.getBaseOwner();
        LiveHashTagInfo r3 = r14.getLiveHashTagInfo();
        String r5 = null;
        if (TextUtils.isEmpty(r14.getTitle()) == false) goto L22;
        if (b4() == false) goto L18;
        if (r3 == null) goto L15;
        this.r.setText(r3.name);
    L27:
        ImageModel r4 = (ImageModel) r14.getCover();
        if (r4 != null) goto L30;
    L33:
        this.s.setImageResource(2131250288);
        d4(r4);
    L34:
        ImageModel r6 = r14.getFeedRoomLabel();
        ImageModel r7 = r14.getOperationLabel();
        if (r6 != null) goto L37;
    L40:
        this.t.setVisibility(8);
    L41:
        Room r8 = this.n;
        if (r8 == null) goto L55;
        TextView r9 = this.A;
        if (r8.getStatus() != 4) goto L47;
        String r10 = s1.B(2131916603);
    L48:
        r9.setText(r10);
        if (r8.getStatus() != 4) goto L51;
        this.v.setVisibility(4);
        goto L55
    L51:
        this.v.setText(p1.a(r8));
        if (p1.c(r8) == false) goto L54;
        this.v.setVisibility(8);
        goto L55
    L54:
        this.v.setVisibility(0);
        goto L55
    L47:
        r10 = s1.B(2131916619);
    L55:
        if (r16 == null) goto L59;
        r5 = r16.getCity();
    L59:
        if (StringUtils.isEmpty(r5) == false) goto L61;
        this.x.setVisibility(8);
        e4(this.w, 8);
    L62:
        View r1 = ((RecyclerView.ViewHolder) this).itemView;
        Object[] r2 = new Object[1];
        if (r16 != null) goto L65;
        String r17 = "";
    L66:
        r2[0] = r17;
        r3.c(r1, s1.C(2131916620, r2), false);
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new jw1.k(this, r13, r14));
        r14.setLog_pb(r13.logPb);
        r14.setRequestId(r13.resId);
        return;
    L65:
        r17 = r16.getRealNickName();
        goto L66
    L61:
        this.x.setText(r5);
        this.x.setVisibility(0);
        goto L62
    L37:
        if (Lists.isEmpty(r6.getUrls()) == true) goto L40;
        this.t.setVisibility(0);
        ImageLoader.bindImageWithAnimation(this.t, r6, new a(this), r6.isAnimated());
        goto L41
    L30:
        if (Lists.isEmpty(r4.getUrls()) == true) goto L33;
        a4(r4, r14);
        goto L34
    L15:
        if (r16 == null) goto L17;
        this.r.setText(r16.getRealNickName());
        goto L27
    L17:
        this.r.setText(null);
        goto L27
    L18:
        if (r16 == null) goto L20;
        this.r.setText(r16.getRealNickName());
        goto L27
    L20:
        this.r.setText(null);
        goto L27
    L22:
        if (b4() == false) goto L26;
        if (r3 == null) goto L25;
        this.r.setText(FormatUtils.format("%s#%s", new Object[]{r14.getTitle(), r3.name}));
        goto L27
    L25:
        this.r.setText(r14.getTitle());
        goto L27
    L26:
        this.r.setText(FormatUtils.format("#%s", new Object[]{r14.getTitle()}));
        goto L27
    L5:
        if (r14.getRedEnvelopeNumber() <= 0) goto L7;
        this.u.setVisibility(0);
    L8:
        ViewGroup.LayoutParams r18 = this.u.getLayoutParams();
        r18.width = s1.f(54.0f);
        r18.height = s1.f(20.0f);
        this.u.setLayoutParams(r18);
        this.u.setImageResource(2131251423);
        goto L9
    L7:
        this.u.setVisibility(4);
        goto L8
    }

    public CommonLiveViewHolder(View r1, tv1.c r2, f r3, FeedDataKey r4, j r5, ILiveRoomListDataSource r6, PublishSubject r7, PublishSubject r8, h r9) {
        super(r1, r2, r3, r4, r5, r6, r7, r8, r9);
        this.r = (TextView) r1.findViewById(2131388772);
        this.s = r1.findViewById(2131378264);
        this.t = r1.findViewById(2131378456);
        this.u = (ImageView) r1.findViewById(2131384103);
        this.v = (TextView) r1.findViewById(2131363364);
        this.w = r1.findViewById(2131376379);
        this.x = (TextView) r1.findViewById(2131379123);
        this.y = (ImageView) r1.findViewById(2131378516);
        this.z = r1.findViewById(2131378473);
        this.A = (TextView) r1.findViewById(2131378472);
        s1.B(2131916615);
    }
}

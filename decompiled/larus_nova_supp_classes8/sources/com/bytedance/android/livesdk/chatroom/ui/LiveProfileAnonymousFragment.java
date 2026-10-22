package com.bytedance.android.livesdk.chatroom.ui;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveProfileAnonymousFragment extends BaseFragment {
    public View d;
    public TextView e;
    public TextView f;
    public RecyclerView g;
    public UserFeatureLabelListAdapter h;
    public User i;
    public String j;
    public String k;
    public long l;
    public boolean m;

    public final String getSpm() {
        return "a100.a213";
    }

    public LiveProfileAnonymousFragment() {
    }

    public final void S90(User r6) {
        this.i = r6;
        if (r6.getAdversaryUserStatus() != 3) goto L18;
        UserFeatureLabelListAdapter r7 = this.h;
        if (r7 == null) goto L18;
        List r0 = this.i.getBadgeImageListV2();
        ArrayList r1 = new ArrayList();
        if (r0 != null) goto L9;
    L17:
        r7.setData(r1);
        return;
    L9:
        if (r0.size() <= 0) goto L17;
        int r2 = 0;
    L12:
        if (r2 >= r0.size()) goto L17;
        if (((py.k) ListProtector.get(r0, r2)).getImageType().intValue() != 1) goto L16;
        r1.add((ImageModel) ListProtector.get(r0, r2));
    L16:
        r2 = r2 + 1;
    L18:
        UIUtils.setViewVisibility(this.g, 8);
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        View r7 = r4.inflate(2131566069, r5, false);
        this.d = r7;
        if (r7 != null) goto L5;
    L7:
        this.e = (TextView) this.d.findViewById(2131392049);
        this.g = this.d.findViewById(2131392021);
        this.f = (TextView) this.d.findViewById(2131392063);
        this.e.setText(this.j);
        if (TextUtils.isEmpty(this.k) == true) goto L10;
        this.f.setText(this.k);
    L10:
        this.h = new UserFeatureLabelListAdapter();
        this.g.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.g.setAdapter(this.h);
        S90(this.i);
        long r8 = SystemClock.uptimeMillis();
        JSONObject r9 = new JSONObject();
        r9.put("type", "native");     // Catch: JSONException -> L13
    L15:
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_profile_first_screen", 0, r8 - this.l, r9);
        return this.d;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        if (this.m == true) goto L7;
        r7.setBackground(com.bytedance.android.live.core.utils.s1.m(2131249450));
        goto L7
    }
}

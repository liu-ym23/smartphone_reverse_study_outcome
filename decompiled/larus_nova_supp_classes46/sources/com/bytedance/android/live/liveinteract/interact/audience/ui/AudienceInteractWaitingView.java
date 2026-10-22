package com.bytedance.android.live.liveinteract.interact.audience.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class AudienceInteractWaitingView extends FrameLayout {
    public AudienceInteractWaitingView(Context r2) {
        super(r2);
        LayoutInflater.from(getContext()).inflate(2131567607, this);
    }

    public AudienceInteractWaitingView(Context r1, AttributeSet r2) {
        super(r1, r2);
        LayoutInflater.from(getContext()).inflate(2131567607, this);
    }

    public final void a(List<k> r6, IBaseUser r7) {
        ArrayList r0 = new ArrayList();
        py.k r1 = r7.getAvatarThumbKt();
        if (r6 == null) goto L20;
        Iterator<k> r8 = r6.iterator();
    L6:
        if (r8.hasNext() == false) goto L20;
        k r2 = r8.next();
        if (r2.getUser() == null) goto L13;
        if (Objects.equals(r2.getUser().getIdString(), r7.getIdString()) == true) goto L13;
        r0.add(r2);
    L13:
        if (r2.getUser() == null) goto L6;
        if (Objects.equals(r2.getUser().getIdString(), r7.getIdString()) == false) goto L6;
        if (r2.getUser().isAnonymous() == false) goto L6;
        r1 = r2.getUser().getAvatarThumbKt();
    L20:
        if (Lists.isEmpty(r0) == false) goto L23;
        HSImageView r9 = findViewById(2131381469);
        r9.setVisibility(0);
        ImageUtil.loadRoundImage(r9, r1);
        return;
    L23:
        if (r0.size() != 1) goto L25;
        findViewById(2131391734).setVisibility(0);
        ImageUtil.loadRoundImage(findViewById(2131391736), r1);
        ImageUtil.loadRoundImage(findViewById(2131391737), ((k) ListProtector.get(r0, 0)).getUser().getAvatarThumbKt());
        return;
    L25:
        findViewById(2131388601).setVisibility(0);
        ImageUtil.loadRoundImage(findViewById(2131388605), r1);
        ImageUtil.loadRoundImage(findViewById(2131388606), ((k) ListProtector.get(r0, 0)).getUser().getAvatarThumbKt());
    }

    public AudienceInteractWaitingView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        LayoutInflater.from(getContext()).inflate(2131567607, this);
    }
}

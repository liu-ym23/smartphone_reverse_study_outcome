package com.bytedance.android.livesdk.interactivity.comment.newinput;

import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.interactivity.api.quickcomment.IQuickCommentShowWord;
import com.google.gson.JsonObject;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public String a;
    public boolean b;
    public boolean c;
    public com.bytedance.android.live.profit.privilege.model.danmu.b d;
    public x22.a e;
    public String f;
    public CharSequence g;
    public boolean h;
    public int i;
    public u22.m.a j;
    public com.bytedance.android.live.base.model.data.activityemoji.b k;
    public com.bytedance.android.livesdk.interactivity.api.emoji.a l;
    public Long m;
    public Long n;
    public LinkedList<IQuickCommentShowWord> o;
    public String p;
    public boolean q;
    public String r;
    public boolean s;
    public OpenInputSource t;
    public long u;
    public boolean v;
    public boolean w;
    public JsonObject x;
    public final Set<com.bytedance.android.livesdk.interactivity.comment.model.a> y;
    public com.bytedance.android.livesdk.interactivity.comment.model.c z;

    public a() {
        this.a = "non_paste";
        this.b = true;
        this.m = 0L;
        this.n = 0L;
        this.t = OpenInputSource.Unknow;
        this.u = -1;
        this.y = new LinkedHashSet();
    }
}

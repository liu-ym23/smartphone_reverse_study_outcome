package com.bytedance.android.live.profile.model;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.p000enum.ProfileMode;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public String a;
    public String b;
    public ProfileRoomProxy c;
    public IRoom d;
    public String e;
    public String f;
    public UserProfileEvent g;
    public ProfileMode h;
    public ProfileMonitor i;
    public boolean j;

    public c() {
        this.a = DataType.FALSE;
        this.e = "";
        this.f = "";
        this.h = ProfileMode.NONE;
    }
}

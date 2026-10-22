package com.bytedance.awemeopen.infra.base.player;

import com.google.gson.JsonElement;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j {
    public final List<i> a;
    public boolean b;
    public long c;
    public long d;
    public String e;
    public boolean f;
    public List<? extends JsonElement> g;
    public long h;
    public final int i;
    public String j;
    public final float k;
    public boolean l;
    public Map<String, String> m;

    public final String toString() {
        return "PlayRequest(playItems=" + this.a + ", isUseSuperResolution=" + this.b + ", startPlayPosition=" + this.c + ", videoDuration=" + this.d + ", playId='" + this.e + "', isAudio=" + this.f + ", videoThumbs=" + this.g + ", urlExpireTime=" + this.h + ", audioSystemStream=" + this.i + ", volumeLoudMeta=" + this.j + ", playbackSpeed=" + this.k + ", resetRenderTarget=false, isMute=false, isLoop=" + this.l + ')';
    }

    public j(List<i> r3) {
        this.a = r3;
        this.b = true;
        this.e = hashCode() + "";
        this.i = -1;
        this.k = 1.0f;
        this.l = true;
    }
}

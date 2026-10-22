package f0a;

import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.platform.api.Image;
import com.larus.platform.api.creation.AudioResource;
import com.larus.platform.api.creation.VideoResource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final ResourceType a;
    public final Image b;
    public final VideoResource c;
    public final AudioResource d;

    public a(ResourceType r3, Image r4, VideoResource r5, AudioResource r6, int r7) {
        if ((r7 & 4) == 0) goto L6;
        r5 = null;
    L6:
        if ((r7 & 8) == 0) goto L8;
        r6 = null;
    L8:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}

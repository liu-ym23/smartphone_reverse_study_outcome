package com.ss.android.lark.locationmessage.message;

import com.bytedance.lark.pb.basic.v1.Content;
import com.bytedance.lark.pb.basic.v1.Image;
import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.bytedance.lark.pb.basic.v1.Location;
import com.ss.android.lark.chat.entity.location.LocationDescription;
import com.ss.android.lark.chat.entity.message.content.LocationContent;
import com.ss.android.lark.image.impl.service.ModelParserImage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i {
    public static final mqb.a.InterfaceC0298a a = null;

    static {
        a = lqb.b.a.getImageDependency();
    }

    public static LocationContent a(Content r7) {
        LocationContent r0 = new LocationContent();
        com.bytedance.lark.pb.basic.v1.LocationContent r8 = r7.location_content;
        if (r8 != null) goto L5;
        return r0;
    L5:
        r0.setLongitude(r8.longitude);
        r0.setLatitude(r8.latitude);
        r0.setZoomLevel(r8.zoom_level.intValue());
        r0.setVendor(r8.vendor);
        r0.setInternal(r8.is_internal.booleanValue());
        Location r1 = r8.location;
        ImageSet r9 = r8.image;
        LocationDescription r2 = null;
        if (r9 != null) goto L8;
        com.ss.android.lark.chat.entity.image.ImageSet r3 = null;
    L9:
        r0.setImage(r3);
        if (r1 == null) goto L13;
        r2 = new LocationDescription();
        r2.setName(r1.name);
        r2.setDescription(r1.description);
    L13:
        r0.setLocationDescription(r2);
        return r0;
    L8:
        r3 = new com.ss.android.lark.chat.entity.image.ImageSet();
        r3.setKey(r9.key);
        mqb.a.InterfaceC0298a r4 = a;
        Image r5 = r9.origin;
        com.ss.android.lark.integrator.im.message.a r6 = (com.ss.android.lark.integrator.im.message.a) r4;
        r6.getClass();
        r3.setOrigin(ModelParserImage.getImage(r5));
        r6.getClass();
        r3.setThumbnail(ModelParserImage.getThumbnailFromPb(r9));
        r6.getClass();
        r3.setMiddle(ModelParserImage.getMiddleFromPb(r9));
        goto L9
    }
}

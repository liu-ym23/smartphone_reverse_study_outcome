package org.apache.poi.poifs.crypt.dsig.services;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;
import javax.xml.crypto.dsig.TransformService;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;

/* JADX INFO: loaded from: classes7.dex */
public class RelationshipTransformService extends TransformService {
    private static final c LOG = null;
    private final List<String> sourceIds;

    /* JADX INFO: renamed from: org.apache.poi.poifs.crypt.dsig.services.RelationshipTransformService$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class POIXmlDsigProvider extends Provider {
        private static final String NAME = "POIXmlDsigProvider";
        static final long serialVersionUID = 1;

        private POIXmlDsigProvider() {
            super(NAME, 1.0d, NAME);
            put("TransformService.http://schemas.openxmlformats.org/package/2006/RelationshipTransform", RelationshipTransformService.class.getName());
            put("TransformService.http://schemas.openxmlformats.org/package/2006/RelationshipTransform MechanismType", "DOM");
        }

        /* synthetic */ POIXmlDsigProvider(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        LOG = b.a(RelationshipTransformService.class);
    }

    public RelationshipTransformService() {
        LOG.atDebug().a("constructor");
        this.sourceIds = new ArrayList();
    }
}

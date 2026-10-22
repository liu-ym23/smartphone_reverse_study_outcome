package org.apache.poi.ss.formula.atp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.NotImplementedFunctionException;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.AverageIf;
import org.apache.poi.ss.formula.functions.Averageifs;
import org.apache.poi.ss.formula.functions.BesselJ;
import org.apache.poi.ss.formula.functions.Bin2Dec;
import org.apache.poi.ss.formula.functions.CeilingMath;
import org.apache.poi.ss.formula.functions.CeilingPrecise;
import org.apache.poi.ss.formula.functions.Complex;
import org.apache.poi.ss.formula.functions.Countifs;
import org.apache.poi.ss.formula.functions.Covar;
import org.apache.poi.ss.formula.functions.Days;
import org.apache.poi.ss.formula.functions.Dec2Bin;
import org.apache.poi.ss.formula.functions.Dec2Hex;
import org.apache.poi.ss.formula.functions.Delta;
import org.apache.poi.ss.formula.functions.DollarDe;
import org.apache.poi.ss.formula.functions.DollarFr;
import org.apache.poi.ss.formula.functions.EDate;
import org.apache.poi.ss.formula.functions.EOMonth;
import org.apache.poi.ss.formula.functions.FactDouble;
import org.apache.poi.ss.formula.functions.FloorMath;
import org.apache.poi.ss.formula.functions.FloorPrecise;
import org.apache.poi.ss.formula.functions.Forecast;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.functions.Gcd;
import org.apache.poi.ss.formula.functions.Hex2Dec;
import org.apache.poi.ss.formula.functions.ImReal;
import org.apache.poi.ss.formula.functions.Imaginary;
import org.apache.poi.ss.formula.functions.Lcm;
import org.apache.poi.ss.formula.functions.Maxifs;
import org.apache.poi.ss.formula.functions.Minifs;
import org.apache.poi.ss.formula.functions.NormDist;
import org.apache.poi.ss.formula.functions.NormInv;
import org.apache.poi.ss.formula.functions.NormSDist;
import org.apache.poi.ss.formula.functions.NormSInv;
import org.apache.poi.ss.formula.functions.NumberValueFunction;
import org.apache.poi.ss.formula.functions.Oct2Dec;
import org.apache.poi.ss.formula.functions.Poisson;
import org.apache.poi.ss.formula.functions.Quotient;
import org.apache.poi.ss.formula.functions.Single;
import org.apache.poi.ss.formula.functions.Sqrtpi;
import org.apache.poi.ss.formula.functions.Sumifs;
import org.apache.poi.ss.formula.functions.TDist2t;
import org.apache.poi.ss.formula.functions.TDistLt;
import org.apache.poi.ss.formula.functions.TDistRt;
import org.apache.poi.ss.formula.functions.TextFunction;
import org.apache.poi.ss.formula.functions.WeekNum;
import org.apache.poi.ss.formula.udf.UDFFinder;

/* JADX INFO: loaded from: classes7.dex */
public final class AnalysisToolPak implements UDFFinder {
    public static final UDFFinder instance = null;
    private final Map<String, FreeRefFunction> _functionsByName;

    private static final class NotImplemented implements FreeRefFunction {
        private final String _functionName;

        public NotImplemented(String r1) {
            this._functionName = r1;
        }

        @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
        public ValueEval evaluate(ValueEval[] r1, OperationEvaluationContext r2) {
            throw new NotImplementedFunctionException(this._functionName);
        }
    }

    static {
        instance = new AnalysisToolPak();
    }

    private AnalysisToolPak() {
        this._functionsByName = createFunctionsMap();
    }

    private Map<String, FreeRefFunction> createFunctionsMap() {
        HashMap r3 = new HashMap(127);
        r(r3, "ACCRINT", null);
        r(r3, "ACCRINTM", null);
        r(r3, "AMORDEGRC", null);
        r(r3, "AMORLINC", null);
        r(r3, "AVERAGEIF", AverageIf.instance);
        r(r3, "AVERAGEIFS", Averageifs.instance);
        r(r3, "BAHTTEXT", null);
        r(r3, "BESSELI", null);
        r(r3, "BESSELJ", BesselJ.instance);
        r(r3, "BESSELK", null);
        r(r3, "BESSELY", null);
        r(r3, "BIN2DEC", Bin2Dec.instance);
        r(r3, "BIN2HEX", null);
        r(r3, "BIN2OCT", null);
        r(r3, "COMPLEX", Complex.instance);
        r(r3, "CEILING.MATH", CeilingMath.instance);
        r(r3, "CEILING.PRECISE", CeilingPrecise.instance);
        r(r3, "CONCAT", TextFunction.CONCAT);
        r(r3, "CONVERT", null);
        r(r3, "COUNTIFS", Countifs.instance);
        r(r3, "COUPDAYBS", null);
        r(r3, "COUPDAYS", null);
        r(r3, "COUPDAYSNC", null);
        r(r3, "COUPNCD", null);
        r(r3, "COUPNUM", null);
        r(r3, "COUPPCD", null);
        r(r3, "COVARIANCE.P", Covar.instanceP);
        r(r3, "COVARIANCE.S", Covar.instanceS);
        r(r3, "CUBEKPIMEMBER", null);
        r(r3, "CUBEMEMBER", null);
        r(r3, "CUBEMEMBERPROPERTY", null);
        r(r3, "CUBERANKEDMEMBER", null);
        r(r3, "CUBESET", null);
        r(r3, "CUBESETCOUNT", null);
        r(r3, "CUBEVALUE", null);
        r(r3, "CUMIPMT", null);
        r(r3, "CUMPRINC", null);
        r(r3, "DAYS", Days.instance);
        r(r3, "DEC2BIN", Dec2Bin.instance);
        r(r3, "DEC2HEX", Dec2Hex.instance);
        r(r3, "DEC2OCT", null);
        r(r3, "DELTA", Delta.instance);
        r(r3, "DISC", null);
        r(r3, "DOLLARDE", DollarDe.instance);
        r(r3, "DOLLARFR", DollarFr.instance);
        r(r3, "DURATION", null);
        r(r3, "EDATE", EDate.instance);
        r(r3, "EFFECT", null);
        r(r3, "EOMONTH", EOMonth.instance);
        r(r3, "ERF", null);
        r(r3, "ERFC", null);
        r(r3, "FACTDOUBLE", FactDouble.instance);
        r(r3, "FLOOR.MATH", FloorMath.instance);
        r(r3, "FLOOR.PRECISE", FloorPrecise.instance);
        r(r3, "FORECAST.LINEAR", Forecast.instance);
        r(r3, "FVSCHEDULE", null);
        r(r3, "GCD", Gcd.instance);
        r(r3, "GESTEP", null);
        r(r3, "HEX2BIN", null);
        r(r3, "HEX2DEC", Hex2Dec.instance);
        r(r3, "HEX2OCT", null);
        r(r3, "IFERROR", IfError.instance);
        r(r3, "IFNA", IfNa.instance);
        r(r3, "IFS", Ifs.instance);
        r(r3, "IMABS", null);
        r(r3, "IMAGINARY", Imaginary.instance);
        r(r3, "IMARGUMENT", null);
        r(r3, "IMCONJUGATE", null);
        r(r3, "IMCOS", null);
        r(r3, "IMDIV", null);
        r(r3, "IMEXP", null);
        r(r3, "IMLN", null);
        r(r3, "IMLOG10", null);
        r(r3, "IMLOG2", null);
        r(r3, "IMPOWER", null);
        r(r3, "IMPRODUCT", null);
        r(r3, "IMREAL", ImReal.instance);
        r(r3, "IMSIN", null);
        r(r3, "IMSQRT", null);
        r(r3, "IMSUB", null);
        r(r3, "IMSUM", null);
        r(r3, "INTRATE", null);
        r(r3, "ISEVEN", ParityFunction.IS_EVEN);
        r(r3, "ISODD", ParityFunction.IS_ODD);
        r(r3, "JIS", null);
        r(r3, "LCM", Lcm.instance);
        r(r3, "MAXIFS", Maxifs.instance);
        r(r3, "MDURATION", null);
        r(r3, "MINIFS", Minifs.instance);
        r(r3, "MROUND", MRound.instance);
        r(r3, "MULTINOMIAL", null);
        r(r3, "NETWORKDAYS", NetworkdaysFunction.instance);
        r(r3, "NOMINAL", null);
        r(r3, "NORM.DIST", NormDist.instance);
        r(r3, "NORM.S.DIST", NormSDist.instance);
        r(r3, "NORM.INV", NormInv.instance);
        r(r3, "NORM.S.INV", NormSInv.instance);
        r(r3, "NUMBERVALUE", NumberValueFunction.instance);
        r(r3, "OCT2BIN", null);
        r(r3, "OCT2DEC", Oct2Dec.instance);
        r(r3, "OCT2HEX", null);
        r(r3, "ODDFPRICE", null);
        r(r3, "ODDFYIELD", null);
        r(r3, "ODDLPRICE", null);
        r(r3, "ODDLYIELD", null);
        r(r3, "PERCENTRANK.EXC", PercentRankExcFunction.instance);
        r(r3, "PERCENTRANK.INC", PercentRankIncFunction.instance);
        r(r3, "POISSON.DIST", Poisson.instance);
        r(r3, "PRICE", null);
        r(r3, "PRICEDISC", null);
        r(r3, "PRICEMAT", null);
        r(r3, "QUOTIENT", Quotient.instance);
        r(r3, "RANDBETWEEN", RandBetween.instance);
        r(r3, "RECEIVED", null);
        r(r3, "RTD", null);
        r(r3, "SERIESSUM", null);
        r(r3, "SINGLE", Single.instance);
        r(r3, "SQRTPI", Sqrtpi.instance);
        r(r3, "STDEV.S", Stdevs.instance);
        r(r3, "STDEV.P", Stdevp.instance);
        r(r3, "SUMIFS", Sumifs.instance);
        r(r3, "SWITCH", Switch.instance);
        r(r3, "TBILLEQ", null);
        r(r3, "TBILLPRICE", null);
        r(r3, "TBILLYIELD", null);
        r(r3, "T.DIST", TDistLt.instance);
        r(r3, "T.DIST.2T", TDist2t.instance);
        r(r3, "T.DIST.RT", TDistRt.instance);
        r(r3, "TEXTJOIN", TextJoinFunction.instance);
        r(r3, "WEEKNUM", WeekNum.instance);
        r(r3, "WORKDAY", WorkdayFunction.instance);
        r(r3, "WORKDAY.INTL", WorkdayIntlFunction.instance);
        r(r3, "XIRR", null);
        r(r3, "XLOOKUP", XLookupFunction.instance);
        r(r3, "XMATCH", XMatchFunction.instance);
        r(r3, "XNPV", null);
        r(r3, "YEARFRAC", YearFrac.instance);
        r(r3, "YIELD", null);
        r(r3, "YIELDDISC", null);
        r(r3, "YIELDMAT", null);
        r(r3, "VAR.S", Vars.instance);
        r(r3, "VAR.P", Varp.instance);
        return r3;
    }

    private static void r(Map<String, FreeRefFunction> r2, String r3, FreeRefFunction r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Object r6 = (FreeRefFunction) ZeusTransformUtils.wrapperContextForParams(r4, FreeRefFunction.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        r6 = new NotImplemented(r3);
    L5:
        r5.put(r3, r6);
    }

    @Override // org.apache.poi.ss.formula.udf.UDFFinder
    public FreeRefFunction findFunction(String r2) {
        if (r2.startsWith("_xlfn.") == false) goto L6;
        r2 = r2.substring(6);
    L6:
        return (FreeRefFunction) ZeusTransformUtils.preCheckCast(this._functionsByName.get(r2.toUpperCase(Locale.ROOT)), FreeRefFunction.class, "com.obric.memorydata.plugin");
    }
}
